function codeMessage(word){
    word = word.trim()
    .replaceAll('a','4')
    .replaceAll('e','3')
    .replaceAll('i','1')
    .replaceAll('o','0')
    .replaceAll('s','5');
    return word;
}
let userInput = ['     javascript is cool','programming is fun     ','      become a coder      '];
userInput.forEach(function(word){
    console.log(codeMessage(word));
})