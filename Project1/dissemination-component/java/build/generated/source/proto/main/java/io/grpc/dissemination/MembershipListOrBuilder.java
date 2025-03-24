// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dissemination.proto

// Protobuf Java Version: 3.25.5
package io.grpc.dissemination;

public interface MembershipListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dissemination.MembershipList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string nodes = 1;</code>
   * @return A list containing the nodes.
   */
  java.util.List<java.lang.String>
      getNodesList();
  /**
   * <code>repeated string nodes = 1;</code>
   * @return The count of nodes.
   */
  int getNodesCount();
  /**
   * <code>repeated string nodes = 1;</code>
   * @param index The index of the element to return.
   * @return The nodes at the given index.
   */
  java.lang.String getNodes(int index);
  /**
   * <code>repeated string nodes = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the nodes at the given index.
   */
  com.google.protobuf.ByteString
      getNodesBytes(int index);
}
