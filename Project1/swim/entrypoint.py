import subprocess
import threading
import time
import sys

def run_java():
    print("Starting Java server...")
    subprocess.Popen([
        "java",
        "-cp", "build/install/dissemination/lib/*",
        "main.java.io.grpc.dissemination.DisseminationServer"
    ], stdout=sys.stdout, stderr=sys.stderr)

def run_python():
    print("Starting Python server...")
    subprocess.Popen([
        "python3",
        "python/server.py"
    ], stdout=sys.stdout, stderr=sys.stderr)

# def run_java_client():
#     print("Starting Java client ping...")
#     subprocess.Popen([
#         "java",
#         "-cp", "build/install/dissemination/lib/*",
#         "main.java.io.grpc.dissemination.TestDisseminationClient_1"
#     ], stdout=sys.stdout, stderr=sys.stderr)

# def run_java_client():
#     print("Starting Java client ping...")
#     subprocess.Popen([
#         "java",
#         "-cp", "build/install/dissemination/lib/*",
#         "main.java.io.grpc.dissemination.TestDisseminationClient_2"
#     ], stdout=sys.stdout, stderr=sys.stderr)

# def run_python_client():
#     print("Starting Python client...")
#     subprocess.Popen([
#         "python3",
#         "python/test_3.py"
#     ], stdout=sys.stdout, stderr=sys.stderr)


# def run_python_client():
#     print("Starting Python client...")
#     subprocess.Popen([
#         "python3",
#         "python/test_4.py"
#     ], stdout=sys.stdout, stderr=sys.stderr)

def run_python_client():
    print("Starting Python client...")
    subprocess.Popen([
        "python3",
        "python/test_5.py"
    ], stdout=sys.stdout, stderr=sys.stderr)


run_java()
run_python()
run_python_client()
# run_java_client()



# 保持主线程活着
while True:
    time.sleep(3600)
