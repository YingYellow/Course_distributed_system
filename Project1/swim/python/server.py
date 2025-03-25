import grpc
from concurrent import futures
import dissemination_pb2
import dissemination_pb2_grpc
import os


class FailureDetectorServicer(dissemination_pb2_grpc.FailureDetectorServicer):
    def Ping(self, request, context):
        print(f"Component FailureDetector of Node received ping from {request.sender_id}", flush=True)
        return dissemination_pb2.AckResponse(success=True)

def serve():
    node_id = os.environ.get("NODE_ID", "node-unknown")
    port = os.environ.get("PYTHON_PORT", "50056")
    print(f"Node_id is {node_id}, port is {port}.", flush=True)
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    dissemination_pb2_grpc.add_FailureDetectorServicer_to_server(FailureDetectorServicer(), server)
    server.add_insecure_port(f"[::]:{port}")
    server.start()
    print(f"Failure detector python server {node_id} started at port {port}...", flush=True)
    server.wait_for_termination()

if __name__ == "__main__":
    serve()
