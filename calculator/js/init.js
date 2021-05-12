// NO USE

var numBtns = [];
var opBtns = [];

for (i = 7; i > 0; i = i - 3) {
  for (j = i; j < i + 3; j++) {
    let btn = document.createElement("button");
    let btnText = document.createTextNode(j);
    btn.appendChild(btnText);
    numBtns.push(btn);
  }
}
for (i = 0; i < 3; i++) {
  let text;
  switch (i) {
    case 0:
      text = " ";
      break;
    case 1:
      text = 0;
      break;
    case 2:
      text = ".";
      break;
  }
  let btn = document.createElement("button");
  let btnText = document.createTextNode(text);
  btn.appendChild(btnText);
  numBtns.push(btn);
}

for (i = 0; i < 7; i++) {
  let text;
  switch (i) {
    case 0:
      text = "C";
      break;
    case 1:
      text = "()";
      break;
    case 2:
      text = "X";
      break;
    case 3:
      text = "%";
      break;
    case 4:
      text = "-";
      break;
    case 5:
      text = "+";
      break;
    case 6:
      text = "=";
      break;
  }
  let btn = document.createElement("button");
  if (text == "=") {
    btn.setAttribute("id", "operate");
  }
  let btnText = document.createTextNode(text);
  btn.appendChild(btnText);
  opBtns.push(btn);
}

var leftBox = document.getElementsByClassName("left");
numBtns.forEach((btn) => {
  leftBox[0].appendChild(btn);
});
var rightBox = document.getElementsByClassName("right");
opBtns.forEach((btn) => {
  rightBox[0].appendChild(btn);
});
