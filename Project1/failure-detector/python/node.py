import threading
import time
import random
from server import serve
from client import ping_node
import os

NODE_ID = os.getenv("NODE_ID", "unknown-node")  
NODES = [f"node-{i}" for i in range(1, 6) if f"node-{i}" != NODE_ID]  # 其他节点

# 启动 Server
server_thread = threading.Thread(target=serve)
server_thread.start()

# 启动 Client，定期 ping 其他节点
def run_client():
    while True:
        target = random.choice(NODES)
        print(f"Node {NODE_ID} is pinging {target}")
        ping_node(target, NODE_ID, NODES, k=2)  # 选择 2 个 helper
        time.sleep(5)

client_thread = threading.Thread(target=run_client)
client_thread.start()

server_thread.join()
client_thread.join()
