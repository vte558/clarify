package com.test.wordcount.driver;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.log4j.Logger;

import com.test.wordcount.WordCountMapper;

public class WordCountDriver {
	private static final Logger sLogger = Logger.getLogger(WordCountDriver.class);
	public static void main(String[] args) {	
		
		
		JobClient client = new JobClient();
		JobConf conf = new JobConf(
				com.test.wordcount.driver.WordCountDriver.class);

		// TODO: specify output types
		sLogger.info("************info test *************");
		sLogger.debug("************debug test *************");
		sLogger.error("************error test *************");
			
		// TODO: specify input and output DIRECTORIES (not files)
	//	conf.setInputPath(new Path("/user/hadoop/hadooptempdir/"));
		//conf.set
		//conf.setOutputPath(new Path("/user/hadoop/hadooptempdir/out"));
		//FileInputFormat.addInputPath(conf, new Path(args[0]));
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(LongWritable.class);
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(LongWritable.class);
		conf.setMapperClass(com.test.wordcount.WordCountMapper.class);
		//dconf.setNumReduceTasks(2);
		// TODO: specify a reducer
		conf.setReducerClass(com.test.wordcount.WordCountReducer.class);
		
		sLogger.info("************info test1 *************");
		sLogger.debug("************debug test1 *************");
		sLogger.error("************error test1 *************");
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf,new Path(args[1]));

		// TODO: specify a mapper
	

		
		client.setConf(conf);
		try {
			sLogger.info("************info test try*************");
			sLogger.debug("************debug test tryt*************");
			sLogger.error("************error test tryn*************");
			JobClient.runJob(conf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
