package com.test.wordcount;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class WordCountReducer extends MapReduceBase implements Reducer<Text,LongWritable,Text,LongWritable> {

	public void reduce(Text key, Iterator<LongWritable> values,
			OutputCollector<Text,LongWritable> output, Reporter reporter) throws IOException {
		// replace KeyType with the real type of your key
		//Text key1 = (Text) key;
       int sum=0;
		while (values.hasNext()) {
			// replace ValueType with the real type of your value
			  sum += values.next().get();
			
			//	sum=sum+value;
	
			// process value
		
		}
		output.collect(key, new LongWritable(sum));
	}

}
