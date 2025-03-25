FROM openjdk:11
WORKDIR /app
COPY java/ /app/
COPY java/build.gradle /app/
COPY java/settings.gradle /app/
COPY java/gradlew /app/
COPY java/gradle /app/gradle
COPY protos /app/protos
RUN chmod +x ./gradlew && ./gradlew installDist


COPY python /app/python
COPY python/requirements.txt /app/

RUN apt-get update && apt-get install -y python3 python3-pip

RUN pip3 install -r python/requirements.txt

#RUN python3 -m grpc_tools.protoc -I. --python_out=python --grpc_python_out=python protos/dissemination.proto

RUN python3 -m grpc_tools.protoc -Iprotos --python_out=python --grpc_python_out=python dissemination.proto

#CMD ["java", "-cp", "build/install/dissemination/lib/*", "main.java.io.grpc.dissemination.DisseminationServer"]

COPY entrypoint.py /app/entrypoint.py

CMD ["python3", "-u", "entrypoint.py"]

#CMD java -cp build/install/dissemination/lib/* main.java.io.grpc.dissemination.DisseminationServer & \
#    python3 python/server.py

