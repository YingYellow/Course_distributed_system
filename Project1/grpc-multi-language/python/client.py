import grpc
from protos import helloworld_pb2
from protos import helloworld_pb2_grpc

def run():
    channel = grpc.insecure_channel("localhost:50051")
    stub = helloworld_pb2_grpc.GreeterStub(channel)
    response = stub.SayHello(helloworld_pb2.HelloRequest(name="Python Client"))
    print("Response from server:", response.message)

if __name__ == "__main__":
    run()
