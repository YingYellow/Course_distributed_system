import grpc
import failure_detector_pb2
import failure_detector_pb2_grpc
import time
import random

def ping_node(target_node, sender_id, nodes_list, k=2):
    """ 发送 ping，如果失败，则请求 k 个其他节点协助 """
    
    channel = grpc.insecure_channel(f"{target_node}:50051")
    stub = failure_detector_pb2_grpc.FailureDetectorStub(channel)

    try:
        response = stub.Ping(failure_detector_pb2.PingRequest(sender_id=sender_id))
        if response.alive:
            print(f"Component FailureDetector of Node {sender_id} received ack from {target_node}")
            return True
    except grpc.RpcError:
        print(f"Component FailureDetector of Node {sender_id} detected failure of {target_node}")

    # **Step 3: 让 k 个其他节点进行二次 ping**
    other_nodes = [n for n in nodes_list if n != target_node and n != sender_id]
    if len(other_nodes) < k:
        k = len(other_nodes)  # 避免 k 过大
    
    selected_helpers = random.sample(other_nodes, k)
    print(f" Node {sender_id} is requesting {selected_helpers} to ping {target_node}")

    successful_pings = 0
    for helper in selected_helpers:
        try:
            channel = grpc.insecure_channel(f"{helper}:50051")
            stub = failure_detector_pb2_grpc.FailureDetectorStub(channel)
            response = stub.Ping(failure_detector_pb2.PingRequest(sender_id=sender_id))
            if response.alive:
                successful_pings += 1
                print(f"Helper {helper} confirmed {target_node} is alive")
        except grpc.RpcError:
            print(f"Helper {helper} also failed to reach {target_node}")

    # **Step 4: 只有当所有 k 个 helpers 都失败时，才确认 target_node 挂了**
    if successful_pings == 0:
        print(f"Node {sender_id} confirms that {target_node} is FAILED")
        return False  # 确认 target_node 真的挂了
    
    return True  # 目标 node 仍然存活
