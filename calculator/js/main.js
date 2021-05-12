// console.log(typeof numButtons);
// console.log(Object.values(numButtons));
// console.log(Array.isArray(Object.values(numButtons)));

const numButtons = document.getElementsByClassName("num");
const opButtons = document.getElementsByClassName("operator");
const operateButton = document.getElementById("operate");

var numbers = [];
var operators = [];

Object.values(numButtons).forEach((btn) => {
  let val = btn.dataset.num;
  btn.addEventListener("click", () => {
    putNum(val);
    console.log(numbers)
  });
});

Object.values(opButtons).forEach((btn) => {
  let val = btn.dataset.op;
  btn.addEventListener("click", () => {
    //val 의 두 경우는 따로 계산. delete와 bracket
    console.log(val)
  });
});

operateButton.addEventListener("click", () => {
  console.log("최종연산")
})



function putNum(num) {
  if (operators.length == numbers.length) {
    if (num == ".") {
      numbers.push("0.");
    } else {
      numbers.push(String(num));
    }
  } else if (operators.length < numbers.length) {
    //숫자 계속 입력중
    
    let isFloat = String(numbers[numbers.length - 1]).indexOf(".")
    if (isFloat == -1) {
      //현재까지 소숫점 없음
      if (numbers[numbers.length - 1] == "0" && num != ".") {
        numbers[numbers.length - 1] = num;
      } else if (num == ".") {
        numbers[numbers.length - 1] = String(numbers[numbers.length - 1]) + num;
      } else if (numbers[numbers.length - 1] != "0") {
        numbers[numbers.length - 1] = String(
          Number(numbers[numbers.length - 1]) * 10 + Number(num)
        );
      }
    } else { // 소수가 입력중
      if(num == "."){
        return
      }
      numbers[numbers.length - 1] = String(numbers[numbers.length - 1]) + num;      
    }
  }
}

// console.log(
//   eval(numbers[0] + operators[0] + numbers[1] + operators[1] + numbers[2])
// );
