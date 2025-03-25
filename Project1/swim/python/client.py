import grpc
import dissemination_pb2
import dissemination_pb2_grpc
import time
import random

NODE_PORTS = {
    "node-1": 50056,
    "node-2": 50057,
    "node-3": 50058,
    "node-4": 50059,
    "node-5": 50060,
}

JAVA_NODE_PORTS = {
    "node-1": 50051,
    "node-2": 50052,
    "node-3": 50053,
    "node-4": 50054,
    "node-5": 50065,
}

def ping_node(target_node, sender_id, nodes_list, k=2):
    port = NODE_PORTS.get(target_node, 50056)
    channel = grpc.insecure_channel(f"{target_node}:{port}")
    stub = dissemination_pb2_grpc.FailureDetectorStub(channel)

    try:
    # print(f"target_node = {target_node}, sender_id = {sender_id}")
        response = stub.Ping(dissemination_pb2.PingRequest(sender_id=sender_id))

        #NOTE: Simulate the failure
        if sender_id == "node-2" or sender_id == "node-3":
            raise grpc.RpcError("Simulated failure")

        if response.success:
            print(f"Component FailureDetector of Node {sender_id} received ack from {target_node}", flush=True)
            return True
    except grpc.RpcError:
        print(f"Component FailureDetector of Node {sender_id} detected failure of {target_node}", flush=True)

    other_nodes = [n for n in nodes_list if n != target_node and n != sender_id]
    if len(other_nodes) < k:
        k = len(other_nodes) 
    
    selected_helpers = random.sample(other_nodes, k)  #NOTE: Simulating the membership list
    print(f" Node {sender_id} is requesting {selected_helpers} to ping {target_node}", flush=True)

    successful_pings = 0
    # Ask help from other nodes in membership list
    for member in selected_helpers:
        try:
            port = NODE_PORTS.get(member, 50056)
            channel = grpc.insecure_channel(f"{member}:{port}")
            stub = dissemination_pb2_grpc.FailureDetectorStub(channel)
            response = stub.Ping(dissemination_pb2.PingRequest(sender_id=sender_id))

            # NOTE: Simulate the failure
            if sender_id == "node-3":
                raise grpc.RpcError("Simulated failure")
        
            if response.success:
                successful_pings += 1
                print(f"Member {member} confirmed {target_node} is alive", flush=True)
        except grpc.RpcError:
            print(f"Member {member} also failed to reach {target_node}")

    # All Helper thought it is failed, it's failed.
    if successful_pings == 0:
        print(f"Node {sender_id} confirms that {target_node} is FAILED", flush=True)

        for member in selected_helpers: 
            report_failure_to_java(target_node, sender_id, member, JAVA_NODE_PORTS[member])

        return False  
    
    return True  


def report_failure_to_java(failed_node, sender_id, target_node_address, port=50052):
    try:

        with grpc.insecure_channel(f"{target_node_address}:{port}") as channel:
            stub = dissemination_pb2_grpc.DisseminationStub(channel)
            
            request = dissemination_pb2.FailureReport(
                sender_id=sender_id,
                failed_node=failed_node
            )
            
            response = stub.ReportFailure(request)
            
            if response.success:
                print(f"[Broadcast] Node {sender_id} reported failure of {failed_node} to {target_node_address}:{port}")
            else:
                print(f"[Broadcast] ReportFailure to {target_node_address}:{port} failed (not acknowledged)")
    
    except grpc.RpcError as e:
        print(f"[Broadcast ERROR] Failed to report failure of {failed_node} to {target_node_address}:{port}: {e}")



# if __name__ == "__main__":

