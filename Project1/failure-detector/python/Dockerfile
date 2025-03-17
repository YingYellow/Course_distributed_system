FROM python:3.9

WORKDIR /app
COPY protos/failure_detector.proto /app/
COPY python/client.py /app/
COPY python/server.py /app/
COPY python/requirements.txt /app/
RUN pip install -r requirements.txt
RUN python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. failure_detector.proto
COPY python/node.py /app/
CMD ["python", "-u", "node.py"]


