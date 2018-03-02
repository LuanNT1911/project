package com.rest.s3config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;



@Configuration
public class S3Config {
	
	@Bean
	public AmazonS3 s3client() throws Exception {
		
		String awsId="AKIAJAN6RZX67PTQZK5A";
		String awsKey="ls0gl4Kr3rj+ZiAa5Xn7htdBcNopEhEY262CNye5";
		String region=ConfigProperties.getInstance().getValue("jsa.s3.region");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
												 .withRegion(Regions.fromName(region))
												 .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
												 .build();
		return s3client;
		
	}
		
}
