function translateString() {
    var sentence = document.getElementById("sentence").value;
    var listWords = sentence.split(" ");
    var pigLatinArr = [];

    for (var i = 0; i < listWords.length; i++) {
        var wordLength = listWords[i].length;
        var firstWord;
        pigLatinArr.push(listWords[i].substring(1, wordLength) + (listWords[i].charAt(0)).toLowerCase() + "ay");
    }
    var pigLatinString = pigLatinArr.toString();
    document.write(pigLatinString.replace(/,/g, ' '));

}