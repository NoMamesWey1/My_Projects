#project 4 altered
import math

total = 0
amount = 0
max_aqi = 0
#concentration values & aqi
air_quality = [(0,50),(51,100),(101,150),(151,200),(201,300),(301,500)]
air_quality_description = [(0,50,"Good"),(51,100,"Moderate"),(101,150,"Unhealthy for Sensitive Groups"),
               (151,200,"Unhealthy"),(201,300,"Very Unhealthy"),(301,500,"Hazardous")]
pm2_5_concentrations = [(0,12.0),(12.1,35.4),(35.5,55.4),(55.5,150.4),(150.5,250.4),(250.5,500.4)]
pm10_concentrations = [(0,54),(55,154),(155,254),(255,354),(355,424),(425,604)]
no2_concentrations = [(0,53),(54,100),(101,360),(361,649),(650,1249),(1250,2049)]
so2_concentrations = [(0,35),(36,75),(76,185),(186,304),(305,604),(605,1004)]
co_concentrations = [(0,4.4),(4.5,9.4),(9.5,12.4),(12.5,15.4),(15.5,30.4),(30.5,50.4)]
o3_8hr_concentrations = [(0,54),(55,70),(71,85),(86,105),(106,200),(0,0)]
o3_1hr_concentrations = [(0,0),(0,0),(125,164),(165,204),(205,404),(405,604)]

def calculate_index(measurement, concentrations, indexes):
    #AQI Equation ((I-high - I-low) / (C-high - C-low)) * (Cp - C-low) + I-low
    for x in range(6):
        value1,value2 = concentrations[x]
        if measurement >= value1 and measurement <= value2:
            I_low,I_high = indexes[x]
            C_low,C_high = concentrations[x]
            indexlvl = ((I_high - I_low) / (C_high - C_low)) * (measurement - C_low) + I_low
            indexlvl = round(indexlvl,0)
            return indexlvl
        else:
            continue

def index_quality(index):
    for x in range(6):
        value1,value2,quality = air_quality_description[x]
        if index >= value1 and index <= value2:
            return quality
        else:
            continue

if __name__ == '__main__':
    print("Air Quality Index Calculator\n")
    #location
    location = input("What is the name of the location? ")
    
    #PM-2.5 (Fine Particulate Matter) Reading and Calculations
    pm2_5 = float(input("\n -> Enter PM-2.5 [ug/m3, 24-hr avg]: "))
    if pm2_5 < 0 or pm2_5 > 500.4:
        indexlvl = -1
    else:
        pm2_5 = int(pm2_5 * 10)/10
        indexlvl_a = calculate_index(pm2_5,pm2_5_concentrations,air_quality)
        index = index_quality(indexlvl_a)
        total = total + round(indexlvl_a,0)
        amount += 1
        max_aqi = indexlvl_a
        pollutant = "PM-2.5"
        print(f"    PM-2.5 concentration of {pm2_5} is index level {indexlvl_a:.0f} ({index})")
    #PM-10 (Coarse Particulate Matter) Reading and Calculations
    pm10 = float(input("\n -> Enter PM-10 [ug/m3, 24-hr avg]: "))
    if pm10 < 0 or pm10 >604:
        indexlvl = -1
    else:
        pm10 = math.trunc(pm10)
        indexlvl_b = calculate_index(pm10,pm10_concentrations,air_quality)
        index = index_quality(indexlvl_b)
        total = total + round(indexlvl_b,0)
        amount += 1
        max_aqi = max(max_aqi,indexlvl_b)
        max_aqi = math.trunc(max_aqi)
        #Determining pollutant
        if max_aqi == indexlvl_b:
            pollutant = 'PM-10'
        else:
            pollutant = pollutant
    
        print(f"    PM-10 concentration of {pm10} is index level {indexlvl_b:.0f} ({index})")
    #NO_2 (Nitrogen Dioxide) Reading and Calculations
    no2 = float(input("\n -> Enter NO-2 [ppb, 1-hr avg]: "))
    if no2 < 0 or no2 > 2049:
        indexlvl = -1
    else:
        no2 = math.trunc(no2)
        indexlvl_c = calculate_index(no2,no2_concentrations,air_quality)
        index = index_quality(indexlvl_c)
        total = total + round(indexlvl_c,0)
        amount += 1
        max_aqi = max(max_aqi,indexlvl_c)
        max_aqi = math.trunc(max_aqi)
        #Determining pollutant
        if max_aqi == indexlvl_c:
            pollutant = 'NO-2'
        else:
            pollutant = pollutant
        
        print(f"    NO-2 concentration of {no2} is index level {indexlvl_c:.0f} ({index})")
    #SO_2 (Sulphur Dioxide) Reading and Calculations
    so2 = float(input("\n -> Enter SO-2 [ppb, 1-hr avg]: "))
    if so2 < 0 or so2 > 1004:
        indexlvl = -1
    else:
        so2 = math.trunc(so2)
        indexlvl_d = calculate_index(so2,so2_concentrations,air_quality)
        index = index_quality(indexlvl_d)
        total = total + round(indexlvl_d,0)
        amount += 1
        max_aqi = max(max_aqi,indexlvl_d)
        max_aqi = math.trunc(max_aqi)
        #Determining pollutant
        if max_aqi == indexlvl_d:
            pollutant = 'SO-2'
        else:
            pollutant = pollutant
        
        print(f"    SO-2 concentration of {so2} is index level {indexlvl_d:.0f} ({index})")
    #CO (Carbon Monoxide) Reading and Calculations
    co = float(input("\n -> Enter CO [ppm, 8-hr avg]: "))
    if co < 0 or co > 50.4:
        indexlvl = -1
    else:
        co = int(co*10)/10
        indexlvl_e = calculate_index(co,co_concentrations,air_quality)
        index = index_quality(indexlvl_e)
        total = total + round(indexlvl_e,0)
        amount += 1
        max_aqi = max(max_aqi,indexlvl_e)
        max_aqi = math.trunc(max_aqi)
        #Determining pollutant
        if max_aqi == indexlvl_e:
            pollutant = 'CO'
        else:
            pollutant = pollutant
        
        print(f"    CO concentration of {co} is index level {indexlvl_e:.0f} ({index})")
    #O3(8hr) Reading and Calculations
    o3_8hr = float(input("\n -> Enter O3 [ppb, 8-hr avg]: "))
    if o3_8hr < 0 or o3_8hr > 200:
        indexlvl_1 = -1
    else:
        o3_8hr = math.trunc(o3_8hr)
        indexlvl_1 = calculate_index(o3_8hr,o3_8hr_concentrations,air_quality)
        index_1 = index_quality(indexlvl_1)
        total = total + round(indexlvl_1,0)
        amount += 1
        max_aqi = max(max_aqi,indexlvl_1)
        max_aqi = math.trunc(max_aqi)
        #Determining pollutant
        if max_aqi == indexlvl_1:
            pollutant = 'O3'
        else:
            pollutant = pollutant
        
    #O3(1hr) Reading and Calculations
    o3_1hr = float(input(" -> Enter O3 [ppb, 1-hr avg]: "))
    if o3_1hr < 125 or o3_1hr > 604:
        indexlvl_2 = -1
    else:
        o3_1hr = math.trunc(o3_1hr)
        indexlvl_2 = calculate_index(o3_1hr,o3_1hr_concentrations,air_quality)
        index_2 = index_quality(indexlvl_2)
        total = total + round(indexlvl_2,0)
        amount += 1
        max_aqi = max(max_aqi,indexlvl_2)
        max_aqi = math.trunc(max_aqi)
        #Determining pollutant
        if max_aqi == indexlvl_2:
            pollutant = 'O3'
        else:
            pollutant = pollutant
        
    #Determining which O3 or none
    if indexlvl_1 == -1 and indexlvl_2 == -1:
        print_statement = "nothing shall print since both are out of range"#hopefully...
    else:
        if indexlvl_1 > indexlvl_2:
            indexlvl = indexlvl_1
            index = index_1
            o3 = o3_8hr
        else:
            indexlvl = indexlvl_2
            index = index_2
            o3 = o3_1hr
        print(f"    O3 concentration of {o3} is index level {indexlvl:.0f} ({index})")
    #something to calc
    max_aqi = math.trunc(max_aqi)
    print(f"\nAQI for {location} is {max_aqi}")
    aqi = index_quality(max_aqi)
    print(f"Air Quality: {aqi}\n")
    print("Summary:")
    print(f"    Pollutant with highest index level is {pollutant}")
    avg = total/amount
    avg = int(avg*10)/10
    print(f"    Average index level is {avg}")
