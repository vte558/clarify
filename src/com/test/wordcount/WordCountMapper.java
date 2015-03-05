package com.test.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.log4j.Logger;

import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

public class WordCountMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text,LongWritable > {

	private static final Logger sLogger = Logger.getLogger(WordCountMapper.class);
	private LongWritable intw=new LongWritable(1);
	private Text word = new Text();
	
	public void map(LongWritable key, Text values,
			OutputCollector<Text,LongWritable> output, Reporter reporter) throws IOException {
	//	String word="";
		String line =values.toString();
		String[] splitLine =line.split(" ");
		System.out.println("key in mapper :"+key);
		//sLogger.setLevel(Debug);
		sLogger.debug("Debug message key"+key );
		sLogger.info("Info message  key"+key);
		sLogger.info("Info message  key"+key);
		sLogger.info("Info message  key"+key);
		sLogger.warn("Warn message key"+key);
		sLogger.error("Error message key"+key); 
		sLogger.fatal("Fatal message key"+key);
		sLogger.info("===============test==============");
		for (int i=0;i<splitLine.length;i++){
		System.out.println("splited word  in mapper :"+splitLine[i]);
		
		//word =splitLine[i];
		word.set(splitLine[i]);
		output.collect(word, intw);
		
		}
	}

}
