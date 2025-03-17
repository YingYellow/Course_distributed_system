import grpc
from concurrent import futures
import failure_detector_pb2
import failure_detector_pb2_grpc

class FailureDetectorServicer(failure_detector_pb2_grpc.FailureDetectorServicer):
    def Ping(self, request, context):
        print(f"Component FailureDetector of Node received ping from {request.sender_id}")
        return failure_detector_pb2.AckResponse(alive=True)

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    failure_detector_pb2_grpc.add_FailureDetectorServicer_to_server(FailureDetectorServicer(), server)
    server.add_insecure_port("[::]:50051")
    server.start()
    print("Node is running...")
    server.wait_for_termination()
