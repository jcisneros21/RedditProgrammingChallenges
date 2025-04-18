

romanDict = { 'M' : 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1 }
keyList = {k:i for i,k in enumerate(romanDict.keys())}

def romanToInt( romanString ):

    '''Computes the total based on the passed roman characters in the string.'''

    total = 0
    prevCharIndex = ''
    for character in romanString:
        currentCharIndex = keyList[character]

        if prevCharIndex != '' and prevCharIndex > currentCharIndex:
            total -= romanDict[character]
        else:
            total += romanDict[character]

        prevCharIndex = keyList[character]
    
    return total


def numcompare ( roman1 , roman2 ):

    '''Returns a boolean value based on whether roman1 is less than roman2'''

    x, y = romanToInt ( roman1 ) , romanToInt ( roman2 )
    if x < y:
        return True
    else:
        return False


print ( numcompare ( "I" , "I" ) )
print ( numcompare ( "I" , "II" ) )
print ( numcompare ( "II" , "I" ) )
print ( numcompare ( "V" , "IIII" ) )
print ( numcompare ( "MDCLXV" , "MDCLXVI" ) )
print ( numcompare ( "MM" , "MDCCCCLXXXXVIIII" ) )
print ( numcompare ( "VIIIIM" , "I" ) )
print ( keyList )

#jessie.cisneros - Adding comment of work performed.