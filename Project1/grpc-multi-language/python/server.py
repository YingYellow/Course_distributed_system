import grpc
import helloworld_pb2
import helloworld_pb2_grpc
from concurrent import futures

class GreeterServicer(helloworld_pb2_grpc.GreeterServicer):
    def SayHello(self, request, context):
        print(f"Received request from client: {request.name}")
        return helloworld_pb2.HelloReply(message=f"Hello, {request.name} from Python Server!")

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    helloworld_pb2_grpc.add_GreeterServicer_to_server(GreeterServicer(), server)
    server.add_insecure_port("[::]:50051")
    server.start()
    print("Python gRPC Server running on port 50051...")
    server.wait_for_termination()

if __name__ == "__main__":
    serve()
