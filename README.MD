# How to access the game
Run in VSC via the DRIVER file (MAIN.java)

# Inputs/How to play the game
Press ENTER on Title Screen to start game
Use D-PAD on right-hand side of the screen to move, middle button (ACTION button) to perform actions when prompted (combat)

# The actual essay part (???)
Most of what I used in making the game came from stuff we learn in class. I chose to use switch statements for the movement system instead of if/else statements, since writing what I wrote as switch statements would unnecessarily convolute an already pretty dense system. Other than the switch statements, everything else came from what we learnt in class!

The hardest part of making the game was creating the GUI. While not using a layout manager is rewarding, it's a little bit hard to wrap your head around the first few times you do it. Only two layout managers were used in the entire GUI (mainInfoPanel, GridLayout; directionalButtonsPanel, BorderLayout), the rest were created by using the setBounds method. I ran into a problem where the panels wowuldn't want to draw outside of a certain bound. After messing around with the GUI elements, and trying everything I could think of, I called in some extra help. After a 20 minute phone call, I had used the repaint and revalidate methods to fix this issue for what seems to be a common problem when it comes to graphical Java elements. Another problem I had was trying to get ImageIcons in JLabels to appear. I decided to put that on the chopping block and not worry about it, since the program was completely functionable without them! An option could be to use Lines and Shapes and such and draw them inside the program but... in my opinion, doing that is unnecessarily hard when you can just pop into MS Paint and draw up a little something very quick. That's exactly what I did, after all: no perspective grids or tools required!

I believe that if I wanted to revist this idea in the future, I could build a slightly larger (but still minor) game out of this inital framework. With a little bit of code optimization, and making new classes, there's no reason why it *shouldn't* work as a dinky but functional dungeon crawler. Maybe I will; there's not many Kirby fangames out there that I know of!

This isn't meeting word count (1,000) but everything I said here covers majority of the process I went through making the game. It was really enjoyable (if frustrating at some times when the program doesn't work when it should work), I'm really grateful for this opportunity, and I would do it again! I'm thinking about over Christmas break making a small little game just to keep myself busy and not forget what I've learnt.
