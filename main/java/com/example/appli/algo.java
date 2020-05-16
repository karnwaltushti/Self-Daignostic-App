//package com.example.appli;

import java.io.File;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.core.Instances;
import weka.core.DenseInstance;
import weka.core.converters.ArffLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;


public class algo {
	
	public static Instances getDataSet(String fileName) throws Exception {
		/**
		 * we can set the file i.e., loader.setFile("finename") to load the data
		 */
		
        
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(filename));

        
        Instances data = loader.getDataSet();

		
		return data;
	}

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

        Random rand = new Random(seed);   // create seeded number generator
        randData = new Instances(data);   // create copy of original data
        randData.randomize(rand); 
        
        Instances train = randData.trainCV(folds, 0);
        Instances test = randData.testCV(folds, 0);

		//Instances testingDataSet = getDataSet(TESTING_DATA_SET_FILENAME);
		//Instances predictingDataSet = getDataSet(PREDICTION_DATA_SET_FILENAME);
		/** Classifier here is Linear Regression */
		Classifier classifier = new NaiveBayesMultinomial();
		/** */
		classifier.buildClassifier(train);
		/**
		 * train the alogorithm with the training data and evaluate the
		 * algorithm with testing data
		 */
		Evaluation eval = new Evaluation(train);
		eval.evaluateModel(classifier, test);
		/** Print the algorithm summary */
		System.out.println("** Naive Bayes Evaluation with Datasets **");
		System.out.println(eval.toSummaryString());
		System.out.print(" the expression for the input data as per alogorithm is ");
		System.out.println(classifier);
		/*for (int i = 0; i < predictingDataSet.numInstances(); i++) {
			System.out.println(predictingDataSet.instance(i));
			double index = classifier.classifyInstance(predictingDataSet.instance(i));
			String className = trainingDataSet.attribute(0).value((int) index);
			System.out.println(className);
		}
*/
	}
}

