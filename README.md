# OCRNetv2
The 'Hello World' of neural nets, optical character regognition.
This network was created for the purposes of a real time demo, so it is quite small (single hidden layer), but it runs quickly, and allows people a first hand look at the innerworkings. The code can be modified to any size (though good luck reading it).
It also features my handwritten, simplistic game engine.

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
  
  <h2> Network </h2>
  Handles the 
