package com.google.tagmanager.proto;

import com.google.analytics.containertag.proto.Serving;
import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import com.google.tagmanager.protobuf.nano.ExtendableMessageNano;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.ArrayList;

public interface Resource {

    public static final class ResourceWithMetadata extends ExtendableMessageNano {
        public static final ResourceWithMetadata[] EMPTY_ARRAY = new ResourceWithMetadata[0];
        public Serving.Resource resource = null;
        public Serving.SupplementedResource supplementedResource = null;
        public long timeStamp = 0;

        public final ResourceWithMetadata clear() {
            this.timeStamp = 0;
            this.resource = null;
            this.supplementedResource = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof ResourceWithMetadata)) {
                return false;
            }
            ResourceWithMetadata other = (ResourceWithMetadata) o;
            if (this.timeStamp == other.timeStamp && (this.resource != null ? this.resource.equals(other.resource) : other.resource == null) && (this.supplementedResource != null ? this.supplementedResource.equals(other.supplementedResource) : other.supplementedResource == null)) {
                if (this.unknownFieldData == null) {
                    if (other.unknownFieldData == null) {
                        return true;
                    }
                } else if (this.unknownFieldData.equals(other.unknownFieldData)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((((((int) (this.timeStamp ^ (this.timeStamp >>> 32))) + 527) * 31) + (this.resource == null ? 0 : this.resource.hashCode())) * 31) + (this.supplementedResource == null ? 0 : this.supplementedResource.hashCode())) * 31;
            if (this.unknownFieldData != null) {
                i = this.unknownFieldData.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            output.writeInt64(1, this.timeStamp);
            if (this.resource != null) {
                output.writeMessage(2, this.resource);
            }
            if (this.supplementedResource != null) {
                output.writeMessage(3, this.supplementedResource);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, output);
        }

        public int getSerializedSize() {
            int size = 0 + CodedOutputByteBufferNano.computeInt64Size(1, this.timeStamp);
            if (this.resource != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(2, this.resource);
            }
            if (this.supplementedResource != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(3, this.supplementedResource);
            }
            int size2 = size + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = size2;
            return size2;
        }

        public ResourceWithMetadata mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.timeStamp = input.readInt64();
                        continue;
                    case 18:
                        this.resource = new Serving.Resource();
                        input.readMessage(this.resource);
                        continue;
                    case 26:
                        this.supplementedResource = new Serving.SupplementedResource();
                        input.readMessage(this.supplementedResource);
                        continue;
                    default:
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, input, tag)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public static ResourceWithMetadata parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (ResourceWithMetadata) MessageNano.mergeFrom(new ResourceWithMetadata(), data);
        }

        public static ResourceWithMetadata parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new ResourceWithMetadata().mergeFrom(input);
        }
    }
}
