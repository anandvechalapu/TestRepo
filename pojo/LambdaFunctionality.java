public class LambdaFunctionality {

    public void implementLambdaFunctionality() {
        // Initialize AWS Lambda client
        AWSLambda lambdaClient = AWSLambdaClientBuilder.standard().build();
        
        // Create Lambda function
        CreateFunctionRequest createFunctionRequest = new CreateFunctionRequest()
            .withFunctionName("SacralAIFunction")
            .withRuntime(Runtime.JAVA8)
            .withRole("arn:aws:iam::[account_id]:role/SacralAILambdaRole")
            .withHandler("com.sacral.LambdaHandler::handleRequest")
            .withCode(new FunctionCode()
                .withZipFile(
                    new ByteBuffer.wrap(
                        Files.readAllBytes(Paths.get("SacralAI.zip"))));
            
        CreateFunctionResult createFunctionResult = lambdaClient.createFunction(createFunctionRequest);
        String functionArn = createFunctionResult.getFunctionArn();
        
        // Invoke Lambda function
        InvokeRequest invokeRequest = new InvokeRequest()
            .withFunctionName("SacralAIFunction")
            .withPayload("payload");
            
        InvokeResult invokeResult = lambdaClient.invoke(invokeRequest);
        String logResult = invokeResult.getLogResult();
    }

}