package com.learnings.spring.grpc;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learnings.spring.grpc.PreviewServiceGrpc.PreviewServiceImplBase;

import io.grpc.stub.StreamObserver;

@GRpcService
public class CCPServiceImpl extends PreviewServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CCPServiceImpl.class);

    @Override
    public void preview(PreviewSummary previewSummary, StreamObserver<PreviewSummary> responseObserver) {
        previewSummary = PreviewSummary.newBuilder(previewSummary).setParAmount(100).build();
        responseObserver.onNext(previewSummary);
        LOGGER.info("server responded {}", previewSummary);
        responseObserver.onCompleted();
    }
}
