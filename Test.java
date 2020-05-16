//package com.example.appli;

import java.io.File;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.core.Instances;
import weka.core.converters.CSVLoader;


public class Test {
/**
	 * This method is used to process the input and return the statistics.
	 *
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {

		//Instances DataSet = getDataSet("C:\\Users\\TUSHTI KARNWAL\\Downloads\\disease.csv");

		CSVLoader loader = new CSVLoader();
		loader.setSource(new File("C:\\Users\\TUSHTI KARNWAL\\Downloads\\disease.csv"));

		
		Instances data = loader.getDataSet();
		data.setClass(data.attribute("source"));;

		CSVLoader loader1 = new CSVLoader();
		loader1.setSource(new File("C:\\Users\\TUSHTI KARNWAL\\Downloads\\pred.csv"));

		//Instances testingDataSet = getDataSet(TESTING_DATA_SET_FILENAME);
		Instances predictingDataSet = loader1.getDataSet();
		/** Classifier here is Linear Regression */
		Classifier classifier = new NaiveBayesMultinomial();
		/** */
		classifier.buildClassifier(data);
		/**
		 * train the alogorithm with the training data and evaluate the
		 * algorithm with testing data
		 */
		Evaluation eval = new Evaluation(data);
		//eval.evaluateModel(classifier, test);
		/** Print the algorithm summary */
		//System.out.println("** Naive Bayes Evaluation with Datasets **");
		//System.out.println(eval.toSummaryString());
		//System.out.print(" the expression for the input data as per alogorithm is ");
		//System.out.println(classifier);

		 // set class attribute
		predictingDataSet.setClassIndex(predictingDataSet.numAttributes() - 1);

		// create copy
		//Instances labeled = new Instances(predictingDataSet);
		System.out.println("Yeay"+predictingDataSet.instance(0));
		// label instances
		//for (int i = 0; i < predictingDataSet.numInstances(); i++) {
			double label = classifier.classifyInstance(predictingDataSet.instance(0));
			//labeled.instance(i).setClassValue(clsLabel);
		//}
		// save labeled data
		
		String className = data.attribute("source").value((int) label);
		System.out.println(className);
		
		/*System.out.println("Yeay"+predictingDataSet.instance(0));
		double index = classifier.classifyInstance(predictingDataSet.instance(0));
		System.out.println("Index"+index);
        String className = data.attribute(0).value((int) index);
            
		System.out.println("Predicted class:"+className);
		/*for (int i = 0; i < predictingDataSet.numInstances(); i++) {
			System.out.println("Yeay"+predictingDataSet.instance(i));
			double index = classifier.classifyInstance(predictingDataSet.instance(i));
			data.setClassIndex(data.numAttributes() - 1);
            String className = data.attribute(0).value((int) index);
            
			System.out.println("Predicted class:"+className);
		}*/

	}
}

