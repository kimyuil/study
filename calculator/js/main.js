// console.log(typeof numButtons);
// console.log(Object.values(numButtons));
// console.log(Array.isArray(Object.values(numButtons)));

const numButtons = document.getElementsByClassName("num");
const opButtons = document.getElementsByClassName("operator");
const operateButton = document.getElementById("operate");

var numbers = [];
var operators = [];
var expression = [];

Object.values(numButtons).forEach((btn) => {
  let val = btn.dataset.num;
  btn.addEventListener("click", () => {
    // putNum(val);
    putNum2(val);
  });
});

Object.values(opButtons).forEach((btn) => {
  let val = btn.dataset.op;
  btn.addEventListener("click", () => {
    //val 의 두 경우는 따로 계산. delete와 bracket
    putOp(val);
  });
});

operateButton.addEventListener("click", () => {
  let outputBox = document.getElementsByClassName("output");
  let result = eval(makeExpression());
  if (isInt(result)) {
    outputBox[0].innerHTML = result;
  } else {
    outputBox[0].innerHTML = parseFloat(result).toFixed(5);
  }
});

function putNum2(num) {
  if (expression[expression.length - 1] == "." && num == ".") {
  } else if (expression[expression.length - 1] == "0" && num == "0") {
  } else if (
    expression[expression.length - 1] == "0" &&
    Number(num) > 0 &&
    Number(num) < 10
  ) {
    expression[expression.length - 1] = num;
  } else if (expression[expression.length - 1] == "-" && num == ".") {
    expression.push("0");
    expression.push(".");
  } else {
    expression.push(num);
  }

  // console.log(expression);
  drawExpression();
}

function putOp(op) {
  if (op == "delete") {
    expression = [];
    document.getElementsByClassName("output")[0].innerHTML = "";
  } else if (isOperator(expression[expression.length - 1]) && isOperator(op)) {
    expression[expression.length - 1] = op;
  } else if (op == "bracket") {
    alert("sorry");
  } else {
    expression.push(op);
  }
  // console.log(expression);
  drawExpression();
}

function isOperator(check) {
  if (check == "+" || check == "-" || check == "/" || check == "*") {
    return true;
  } else {
    return false;
  }
}

function isInt(n) {
  return parseInt(n) === n;
}

function drawExpression() {
  let inputBox = document.getElementsByClassName("inputLine");
  inputBox[0].innerHTML = makeExpression();
}

function makeExpression() {
  let finalExpression = "";
  for (i = 0; i < expression.length; i++) {
    finalExpression += expression[i];
  }
  return finalExpression;
}

// function putNum(num) {
//   if (operators.length == numbers.length) {
//     if (num == ".") {
//       numbers.push("0.");
//     } else {
//       numbers.push(String(num));
//     }
//   } else if (operators.length < numbers.length) {
//     //숫자 계속 입력중

//     let isFloat = String(numbers[numbers.length - 1]).indexOf(".");
//     if (isFloat == -1) {
//       //현재까지 소숫점 없음
//       if (numbers[numbers.length - 1] == "0" && num != ".") {
//         numbers[numbers.length - 1] = num;
//       } else if (num == ".") {
//         numbers[numbers.length - 1] = String(numbers[numbers.length - 1]) + num;
//       } else if (numbers[numbers.length - 1] != "0") {
//         numbers[numbers.length - 1] = String(
//           Number(numbers[numbers.length - 1]) * 10 + Number(num)
//         );
//       }
//     } else {
//       // 소수가 입력중
//       if (num == ".") {
//         return;
//       }
//       numbers[numbers.length - 1] = String(numbers[numbers.length - 1]) + num;
//     }
//   }
// }
