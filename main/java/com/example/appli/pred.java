package com.example.appli;

import java.io.File;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.core.Instances;
import weka.core.converters.CSVLoader;


public class pred {
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
		loader.setSource(new File("C:\\Users\\TUSHTI KARNWAL\\Downloads\\pred.csv"));

		//Instances testingDataSet = getDataSet(TESTING_DATA_SET_FILENAME);
		Instances predictingDataSet = loader.getDataSet();
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
		for (int i = 0; i < predictingDataSet.numInstances(); i++) {
			System.out.println(predictingDataSet.instance(i));
			double index = classifier.classifyInstance(predictingDataSet.instance(i));
			String className = data.attribute(0).value((int) index);
			System.out.println(className);
		}

	}
}

