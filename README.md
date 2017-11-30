# OCRNetv2
The 'Hello World' of neural nets, optical character regognition.
This network was created for the purposes of a real time demo, so it is quite small (single hidden layer), but it runs quickly, and allows people a first hand look at the innerworkings. The code can be modified to any size (though good luck reading it).
It also features my handwritten, simplistic game engine.

Checkout the 'Rough Cut' for a sampler of how we used clips, and this code, in our project.
NOTE: There is just the first part of the video, there is a second portion of interviews and conversations which has not been edited into the video yet. This video does not represent the final product in any way, and and all aspects are subject to change.

<h2> Controls </h2>
Press 'space' to advance through the stages, and see the networkd train and test itself.

<h2> Stages </h2>
 - Load in images
 - Show the network a single image
 - Show the network the rest of the images, preforming backpropagated training
 - Test the network out! A new image is tested every time you press space
 
 <h1> Class Breakdown </h1>
 Description of all the classes.
 
 <h2> Driver </h2> 
 Uses an instance of my game engine for the 2d display that is rendered. Manedges keyboard input, and stage advancement.
 
  <h2> Engine2d </h2>
  My game engine, simple rendering manedgement, inputs, flow control, etc.
  
  <h2> Image Stripper </h2>
  Pulls out the small handwritten digit images from the large files within the 'Train' and 'Test' folders. NOTE: the 'Eric' folder containts the handwritten digits of a friend whom wanted to see if it generalized to his own handwritting. It did!
  
  <h2> Network </h2>
  Handles the neural net, each layer is an array of the 'Neuron' class. This manedges the creation, activation, input, training, and output for our neuron nodes.
  
  <h2> Neuron </h2>
  The actual unit of learning, these neurons hold a reference to each node in the previous layer, as well as their weights, and the information needed for rendering. This is where the magic happens!
  
  <h2> Card </h2>
  Represents the intermediate step between 'image' and 'input later' where the image is broken down in a way the neurons can parse.
  
  <h2> Result </h2>
  Just a rendering of the result of a networks guess!
  
  <h2> Thanks </h2>
  
