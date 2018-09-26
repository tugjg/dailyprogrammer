const wordIsFunnel = (word1, word2) => {
  var wordArray = word1.split('');
  for (var i = 0; i < wordArray.length; i++) {
    var testString = '';
    wordArray.splice(i, 1);
    for (var j in wordArray) {
      testString += wordArray[j];
    }
    if (testString == word2) {
      return console.log(word1, word2, 'true');
    }
    wordArray = word1.split('');
  }
  return console.log(word1, word2, 'false');
};

var funnelTests = [
  wordIsFunnel('leave', 'eave'),
  wordIsFunnel('reset', 'rest'),
  wordIsFunnel('dragoon', 'dragon'),
  wordIsFunnel('eave', 'leave'),
  wordIsFunnel('sleet', 'lets'),
  wordIsFunnel('skiff', 'ski'),
];

for (var i = 0; i < funnelTests.length; i++) {
  funnelTests[i];
}
