BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Disasters" (
	"DISASTER_ID"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"DISASTER_NAME"	TEXT,
	"TIP_1"	NAME,
	"TIP_2"	NAME,
	"TIP_3"	NAME,
	"CHECK_1"	NAME,
	"CHECK_2"	NAME,
	"CHECK_3"	NAME
);
INSERT INTO "Disasters" VALUES (1,'Flood','Avoid closed underground spaces as much as possible','Seal off windows/doors that might flood the establishment if left unchecked','If possible, find shelter in a tall building, ideally on a rooftop','Make sure to have sandbags to seal off doors','Make sure to have adequate footwear (Rain and/or high boots)','Make sure to not leave too many electronics, or anything susceptible to flood damage underground.');
INSERT INTO "Disasters" VALUES (2,'Fire
	','Always check for door handles, if they are warm, avoid the room at all cost.','Avoid standing up as inhaling too much smoke could be very harmful. Stay as close to the floor as humanly possible.','Close every window possible, Oxygen helps flames spread.','Regularly test your smoke detectors.','Make sure your establishment has at least 1 fire extinguisher, and that it is not empty.
','Make sure to close the windows whenever you are leaving a building and/or a room, in case a fire happens while you are not present.');
INSERT INTO "Disasters" VALUES (3,'Nuclear Disaster','Look for a hospital if gravely injured, if not, try to help around, social services will most likely be overwhelmed.','Avoid the rain post-nuclear disaster, as it is most likely very acidic.','Look for bottled water, as much as possible, as it is probably gonna become the new currency.','Prepare an underground bunker with non-preishable rations/MREs, ideally enough for a couple of years.','Prepare a lot of bottled water.
','Make sure to warn your friends and neighbors of the upcoming apocalypse.');
INSERT INTO "Disasters" VALUES (4,'Thunderstorm','Find shelter as soon as possible.','Avoid water in general, an unlucky lightning bolt can be the demise of pretty much anyone.
','Avoid the rain as much as possible, getting sick during a storm is the worst possible scenario for anyone trying to survive through the storm.','Make sure to keep track of weather forecasts.','Prepare adequate clothing for dealing with a storm, along with an umbrella','If possible, shelter your car/anything valuable outside of your own house in prevision of an upcoming storm');
INSERT INTO "Disasters" VALUES (5,'Earthquake','Look for a checkpoint, usually a hospital/public establishment where people can help the victims of the earthquake.
','If physically able, look under the rubble, you might save a life.','Hide under tables, in case the ceiling or other rubbles start falling down, a concussion can mean death.','Check if the building you are in has some form of seismic mitigation incorporated inside its structure.','Make sure to keep an eye out for seismic activity. Eartquakes Canada takes care of monitoring recent/potential earthquakes. ','Make sure you do not have valuable objects susceptible to falling and breaking during an earthquake, like vases, or plates.');
INSERT INTO "Disasters" VALUES (6,'Landslide','Call 911, you are in no position to be able to deal with this without greatly endangering yourself.','Get as far from the source as possible, in this case, the valley/plain/mountain in question, a mudslide can make movement nearly impossible after a while.','While it might seem counterintuitive, avoid vehicles as much as possible, as they usually dont have the required tires to drive through thick mud.','Prepare spare mud tires, so that you can use your vehicles.','Check the weather forecast, if you live near a mountain, and strong rain is predicted, you might need to be on your toes.','Make sure your entrances/windows are properly isolated, and that your walls are solid, so that you can ensure staying inside is safe.');
INSERT INTO "Disasters" VALUES (7,'Pandemic','Avoid contact with the infected.','Regularly check for symptoms, if the symptoms match, call 911/go to a hospital','Avoid large gatherings of people, it makes diseases spread like wildfire.','Make sure you have all your vaccine shots.','Always keep spare masks/sanitizer, in case you need to clean your hands/objects.','Make sure you have a great book/hobbies you want to pick up, in case of a quarantine.');
INSERT INTO "Disasters" VALUES (8,'Android 2019','Get in contact with Student Services.','Trust me, just do it','Pray that Student Services already have a file about the teacher','Do your homework.','Be a decent student','Have a genuine interest for the class.');
COMMIT;
