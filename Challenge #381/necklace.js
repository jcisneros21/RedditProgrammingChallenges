
function yahtzee_upper ( numberArray ) {

  var number;
  var countArray = { 1:0, 2:0, 3:0, 4:0, 5:0, 6:0 };

  for (var i = 0; i < numberArray.length; i++) {
    number = numberArray[i];
    countArray[number] = countArray[number] + 1;
  }

  var maxNumber = 0;
  var totalNumber = 0;
  for (var i = 1; i < numberArray.length+2; i++ ){
    totalNumber = countArray[i] * i;
    if (totalNumber > maxNumber) {
      maxNumber = totalNumber;
    }
  }

  return maxNumber;

}

function same_necklace ( String1 , String2 ) {

  // If String1 equals String2
  if (String1 == String2) {
    return true;
  }

  var Stringlength1 = String1.length;
  var Stringlength2 = String2.length;

  if (Stringlength1 != Stringlength2) {
    return false;
  }

  for (var i = 0; i < Stringlength1; i++) {

    var endLength = Stringlength1 - 1;

    var frontSubstring = String2.substring(0,i);
    var backSubstring = String2.substring(i,endLength+1);

    var necklaceString = backSubstring + frontSubstring;

    if (necklaceString == String1) {
      return true;
    }
  }

  return false;
}

function repeats( repeatString ){

  if (repeatString.length <= 1) {
    return 1;
  }

  var count = 0;
  for (var i = 0; i < repeatString.length; i++) {

    var endLength = repeatString.length - 1;

    var frontSubstring = repeatString.substring(0,i);
    var backSubstring = repeatString.substring(i,endLength+1);

    var necklaceString = backSubstring + frontSubstring;

    if (repeatString == necklaceString) {
      count++;
    }
  }

  return count;

}

function incrementDigitByOne( number ){

  var numberString = number.toString();

  var numText = "";
  for (var i = 0; i < numberString.length; i++) {
    var temp = Number( numberString[i] ) + 1;
    numText = numText + temp.toString();
  }

  var finalNumber = Number(numText);
  return finalNumber;
}

function test () {
  var test = "Value";
  console.log ( test.substring(1,3) )
}

function necklaceOutput() {
  console.log(same_necklace("nicole", "icolen"));
  console.log(same_necklace("nicole", "lenico"));
  console.log(same_necklace("nicole", "coneli"));
  console.log(same_necklace("aabaaaaabaab", "aabaabaabaaa"));
  console.log(same_necklace("abc", "cba"));
  console.log(same_necklace("xxyyy", "xxxyy"));
  console.log(same_necklace("xyxxz", "xxyxz"));
  console.log(same_necklace("x", "x"));
  console.log(same_necklace("x", "xx"));
  console.log(same_necklace("x", ""));
  console.log(same_necklace("", ""));
}

function repeatOutput() {
  console.log( repeats("abc") );
  console.log( repeats("abcabcabc") );
  console.log( repeats("abcabcabcx") );
  console.log( repeats("aaaaaa") );
  console.log( repeats("a") );
  console.log( repeats("") );
}

function yahtzeeOutput() {
  console.log ( yahtzee_upper([2, 3, 5, 5, 6]) );
  console.log ( yahtzee_upper([1, 1, 1, 1, 3]) );
  console.log ( yahtzee_upper([1, 1, 1, 3, 3]) );
  console.log ( yahtzee_upper([1, 2, 3, 4, 5]) );
  console.log ( yahtzee_upper([6, 6, 6, 6, 6]) );
}

function main () {
  yahtzeeOutput();
}

main()
