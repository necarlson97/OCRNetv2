import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Network {
	
	Random rand = Engine2D.rand;
	
	Card[] training;
	Card[] test;
	Card[] eric;
	Neuron[] inputLayer;
	Card currCard;
	
	Neuron[] hiddenLayer;
	Neuron[] outputLayer;
	
	Driver driver;
	
	boolean done = false;
	
	Network(int inputs, int hidden, Driver d) {
		driver = d;
		inputLayer = new Neuron[inputs];
		hiddenLayer = new Neuron[hidden];
		outputLayer = new Neuron[10];
		training = driver.getTrainingCards();
		test = driver.getTestCards();
		eric = driver.getEricCards();
		
		createNeurons(inputLayer, null, Driver.cardSize, Driver.cardSize, 20, 50);
		createNeurons(hiddenLayer, inputLayer, Driver.hiddenSize, Driver.hiddenSize, 550, 50);
		createNeurons(outputLayer, hiddenLayer, 1, 10, 700, 50);

		setInput(training[rand.nextInt(training.length)]);
		
	}
	
	void createNeurons(Neuron[] layer, Neuron[] pastLayer, int width, int height, int startingX, int startingY) {
		int r = 0;
		int c = 0;
		int i=0;
		while(c < width) {
			r = 0;
			while(r < height) {
				int x = startingX + c*Driver.pixelSize;
				int y = startingY + r*Driver.pixelSize;
				if(pastLayer == null) layer[i] = new Neuron(x, y);
				else layer[i] = new Neuron(pastLayer, x, y);
				r++;
				i++;
			}
			c++;
		}
	}
	
	void activate(Card card) {
		setInput(card);
		for(int i=0; i<hiddenLayer.length; i++)
			hiddenLayer[i].activate();
		for(int j=0; j<outputLayer.length; j++)
			outputLayer[j].activate();
		
	}
	
	void train(float[] outputs) {
		for(int i=0; i<outputLayer.length; i++) {
			outputLayer[i].setError(outputs[i]);
			outputLayer[i].train();
		}
		for(int i=0; i<hiddenLayer.length; i++) {
			hiddenLayer[i].train();
		}
		done = true;
	}
	
	void setInput(Card card) {
		currCard = card;
		
		for(int i=0; i<inputLayer.length; i++) {
			inputLayer[i].output = card.inputs[i];
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString(currCard.lable+" card", 20, 50);
		
		renderLines(g, inputLayer);
		renderLines(g, hiddenLayer);
		renderLines(g, outputLayer);
		
		renderLayer(g, inputLayer);
		renderLayer(g, hiddenLayer);
		renderLayer(g, outputLayer);
	}
	
	private void renderLines(Graphics g, Neuron[] layer) {
		for(int i=0; i<layer.length; i++) {
			layer[i].renderLines(g);
		}
	}
	
	private void renderLayer(Graphics g, Neuron[] layer) {
		for(int i=0; i<layer.length; i++) {
			layer[i].render(g);
		}
	}

	public void randCard() {
		setInput(training[rand.nextInt(training.length)]);
	}
	
	void printOutput() {
		String str = "Output: \n";
		for(int i=0; i<outputLayer.length; i++) {
			str+="\t"+outputLayer[i].output+"\n";
		}
		System.out.println(str);
	}
	
	float[] tryCard() {
		activate(test[rand.nextInt(test.length)]);
		
		float ret[] = new float[10];
		for(int i=0; i<outputLayer.length; i++)
			ret[i] = outputLayer[i].output;
		return ret;
	}

}
