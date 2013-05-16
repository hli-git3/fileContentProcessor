package com.sky.core.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DuplicationRemover {
	private static final Logger log = LoggerFactory
			.getLogger(DuplicationRemover.class);

	public Set<Integer> removeDuplicateInteger(String fileName) {
		if (fileName == null || fileName.trim().isEmpty()) {
			return null;
		}

		Set<Integer> result = new HashSet<Integer>();

		BufferedReader in = null;
		String tempString = null;
		try {
			in = new BufferedReader(new FileReader(fileName));

			while ((tempString = in.readLine()) != null) {
				tempString = tempString.trim();
				if(!tempString.isEmpty()) {
					result.add(Integer.parseInt(tempString));
				}
			}

		} catch (FileNotFoundException e) {
			log.warn("File {} cannot be found.", fileName);
		} catch (NumberFormatException e) {
			log.warn("{} in file {} cannot be parsed into integer.", tempString, fileName);
		} catch (IOException e) {
			log.warn("File read error.", e);
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.warn("File {} cannot be closed.", fileName);
				}
			}
		}

		return result;
	}
	
	public String convertItemsToString(Collection<Integer> collection) {
		if(collection == null || collection.isEmpty() ) {
			return null;
		}
		
		Iterator<Integer> iterator = collection.iterator();	
		StringBuilder stringBuilder = new StringBuilder();
		
		while(iterator.hasNext()) {
			stringBuilder.append(iterator.next());
			if(iterator.hasNext()){
				stringBuilder.append(", ");
			}
		}
		
		return stringBuilder.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length < 1) {
			log.debug("Syntex: java DuplicationRemover fileName");
			log.debug("fileName is missing.");
			System.exit(-1);
		}
		
		DuplicationRemover remover = new DuplicationRemover();
		
		log.debug(remover.convertItemsToString(remover.removeDuplicateInteger(args[0])));

	}

}
