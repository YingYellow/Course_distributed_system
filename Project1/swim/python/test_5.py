import threading
import time
import random
from server import serve
from client import ping_node
import os

NODE_ID = os.getenv("NODE_ID", "unknown-node")  
NODES = [f"node-{i}" for i in range(1, 6) if f"node-{i}" != NODE_ID]  # 其他节点

server_thread = threading.Thread(target=serve)
server_thread.start()

def run_client():
    time.sleep(1)
    if "node-3" == NODE_ID:
        for i in range(2):
            target = random.choice(NODES)
            print(f"Node {NODE_ID} is pinging {target}")
            ping_node(target, NODE_ID, NODES, k=2) 
    

client_thread = threading.Thread(target=run_client)
client_thread.start()

server_thread.join()
client_thread.join()
