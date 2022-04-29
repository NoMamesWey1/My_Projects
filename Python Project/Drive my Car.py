#Project 2 Drive My Car


def menu():
    print("Main menu:")
    print("1. Cost of Fuel")
    print("2. Used Value")
    print("3. Stopping Distance")
    print("4. Quit")


def Cost_of_fuel():

    MONTHS = 12
     
    #Car 1 is the electric car
    car1_kws = float(input("Enter car 1's kW-h/mi:\n"))
    while car1_kws <= 0:
        car1_kws = float(input("Enter car 1's kW-h/mi:\n"))    
    car1_cost = float(input("Enter cost per kW-h:\n"))
    while car1_cost <= 0:
        car1_cost = float(input("Enter cost per kW-h:\n"))
        
    #Car 2 is the gas car
    car2_mpg = float(input("Enter car 2's MPG:\n"))
    while car2_mpg <= 0:
        car2_mpg = float(input("Enter car 2's MPG:\n"))
    car2_gas = float(input("Enter gas cost per gallon:\n"))
    while car2_gas <= 0:
        car2_gas = float(input("Enter gas cost per gallon:\n"))
        
    #Miles used in month
    car_miles = float(input("How many miles do you drive per month?\n"))
    while car_miles <= 0:
        car_miles = float(input("How many miles do you drive per month?\n"))

    #Calculates each car's total amount of money spent in a year
    car1_tot = ((car1_kws * car_miles) * car1_cost) * MONTHS
    car2_tot = ((car_miles / car2_mpg) * car2_gas) * MONTHS

    #Determing which Car had a greater total
    if car1_tot > car2_tot:
        car = 2 #since car 1 total is greater, car 2 will be the cheaper
        amount = car1_tot - car2_tot
    else: #car2_tot > car1_tot
        car = 1 #since car 2 total is greater, car 1 will be the cheaper 
        amount = car2_tot - car1_tot

    #Deciding if the amount difference is less than 5 to determing if they are the same
    if amount <= 5:
        result=("The two cars cost the same.\n")
    else:
        result=(f"Car {car} will save ${amount:.2f} in a year.\n")
    return result


def Used_value():

    PERCENT_LOSS = 0.18
    
    #Enter Car Price
    car_price = float(input("Enter original car price:\n"))
    while car_price <= 0:
        car_price = float(input("Enter original car price:\n"))

    #Enter years
    years = int(input("Enter number of years:\n"))
    while years <= 0:
        years = int(input("Enter number of years:\n"))

    #Calculating loss in value and printing the how many years they want
    for x in range(1,years+1):
        value = car_price * PERCENT_LOSS
        car_price -= value
        print(f"Year {x} value: ${car_price:.2f}")
    print()

def Stopping_Distance_Calc(U,v_i):
    #Calculating distance it stops
    #Distance equation is (v^2)/(2*u*g)
    ACCELERATION_DUE_TO_GRAVITY = 32.174
    ONE_MILE_IN_FEET = 5280
    FEET_PER_SEC = 3600
    MPH_TO_FEET_PER_SEC = ONE_MILE_IN_FEET / FEET_PER_SEC 
    TWO = 2
    
    distance = ((v_i * MPH_TO_FEET_PER_SEC) ** TWO) / (TWO * U * ACCELERATION_DUE_TO_GRAVITY)
    return distance

def Stopping_distance():
    NEW_TIRES_U = 0.8 #u is the symbol of friction
    GOOD_TIRES_U = 0.6
    POOR_TIRES_U = 0.5

    #Initial speed
    initial_speed = float(input("Enter initial speed:\n"))
    while initial_speed <= 0:
        initial_speed = float(input("Enter initial speed:\n"))

    #Tire condition
    tire_condition = int(input("Enter tire condition (1 = new, 2 = good, 3 = poor):\n"))
    while tire_condition <= 0 or tire_condition > 3:
        tire_condition = int(input("Enter tire condition (1 = new, 2 = good, 3 = poor):\n"))

    #Determining what type of tires and firction 
    if tire_condition == 1:
        tires = "new tires"
        calc = Stopping_Distance_Calc(NEW_TIRES_U, initial_speed)
    elif tire_condition == 2:
        tires = "good tires"
        calc = Stopping_Distance_Calc(GOOD_TIRES_U, initial_speed)
    else: #tire_conditon == 3:
        tires = "poor tires"
        calc = Stopping_Distance_Calc(POOR_TIRES_U, initial_speed)

    print(f"At {initial_speed} miles per hour, with {tires}, the car will stop in {calc:.2f} feet.\n") 
        

if __name__ == "__main__":
    run_again = True
    while run_again == True:
        num = menu()
        user_input = 0
        while user_input <= 0 or user_input > 4:
            user_input = int(input("Choose a function:\n"))
        if user_input == 1:
            cost = Cost_of_fuel()
            print(cost)
        elif user_input == 2:
            Used_value()
        elif user_input == 3:
            Stopping_distance()
        elif user_input == 4:
            break
            





        
