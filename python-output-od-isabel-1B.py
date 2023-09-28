ONE_POUND_TO_KILOGRAMS = 0.453592

userInput = float( input("Weight in Pounds (lbs): ") )

userPoundsToKilograms = userInput * ONE_POUND_TO_KILOGRAMS

print("Weight converted to Kilograms (kg): ", userPoundsToKilograms )

print("==================================================")

ONE_MILES_TO_KILOMETERS = 1.609344

userInput = float( input("Length in Miles (mi): ") )

userMilesToKilometers = userInput * ONE_MILES_TO_KILOMETERS

print("Length in Kilometers (km): ",  userMilesToKilometers )

print("==================================================")

userInput = float( input("Temperature in Fahrenheit (°F): ") )

userFahrenheitToCelcius = (userInput - 32) * 5/9

print("Temperature in Celcius (°C): ", userFahrenheitToCelcius )

print("==================================================")

userInput1 = float (input("Age of Student 1:") )

userInput2 = float (input("Age of Student 2:") )

userInput3 = float (input("Age of Student 3:") )

userInput4 = float (input("Age of Student 4:") )

userInput5 = float (input("Age of Student 5:") )

userInput6 = float (input("Age of Student 6:") )

userInput7 = float (input("Age of Student 7:") )

userInput8 = float (input("Age of Student 8:") )

userInput9 = float (input("Age of Student 9:") )

userInput10 = float (input("Age of Student 10:") )

userAverageOfTheStudent = (userInput1 + userInput2 + userInput3 + userInput4 + userInput5 + userInput6 + userInput7 + userInput8 + userInput9 + userInput10) /10

print("The average age of the students is: ",  userAverageOfTheStudent )

print("==================================================")

# fantasy story 

character1 = "Apple"
character2 = "Orange"
character3 = "Lemon"
character4 = "Grapes"
character5 = "Strawberry"

equipment1 = "magical bow"
equipment2 = "katana"
equipment3 = "spear"
equipment4 = "dagger"
equipment5 = "double edged sword"

item1 = "healing poition"
item2 = "map"
item3 = "magic pouch"
item4 = "invisible clock"
item5 = "shield"

ability1= "fire"
ability2= "water"
ability3= "air"
ability4= "weather"
ability5= "nature"

story1= (f''' In her previous existence, {character1} was incredibly kind. When she was going down the street one day, she was stabbed by a random killer, and when she awoke, she had been reincarnated into the world of imagination. God is sad about her untimely death, so he bestowed upon her the ability to manipulate {ability1} in order for her to survive, as well as a {equipment1} and {item1}''')
story2= (f''' She meets {character2}, {character3}, {character4}, and {character5} after many days of roaming in the fantasy realm. {character2} can control the {ability2}, {character3} can control the {ability3}, {character4} can control the {ability5}, and {character5} can control {ability4}. They come across many monters as they proceed through the dungeon.  {character2} kills creatures with his {equipment3}, while {character3} uses his {equipment2}, {character5} uses his {equipment4}, and {character4} utilizes his {equipment5}. They found a box at the end of the dungeon, and when they opened it, it contained {item2}, {item3}, {item4}, and {item5}''')


print(story1)
print(story2)