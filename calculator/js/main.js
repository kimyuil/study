// console.log(typeof numButtons);
// console.log(Object.values(numButtons));
// console.log(Array.isArray(Object.values(numButtons)));

const numButtons = document.getElementsByClassName("num");

var numbers = [];
var operators = [];

Object.values(numButtons).forEach((btn) => {
  let val = btn.dataset.num;
  btn.addEventListener("click", () => {
    putNum(val);
  });
});

function putNum(num) {
  //numbers[numbers.length] //로 push 예정
  if (operators.length == numbers.length) {
    //처음 넣는 과정
    if (num == ".") {
      numbers.push("0.");
    } else {
      numbers.push(String(num));
    }
  } else if (operators.length > numbers.length) {
    //숫자 계속 입력중

    //현재까지 정수중인지 소수중인지 구분해주어야 함.
    let lastChar = String(numbers[numbers.length - 1]).charAt(
      numbers.length - 1
    );
    if (lastChar == ".") {
      //소수시작
    } else {
      //아직까지 정수 입력중
      if (numbers[numbers.length - 1] == "0" && num != ".") {
        numbers[numbers.length - 1] = num;
      } else if (num == ".") {
        //맨 끝이 . 으로 끝나는지 check
        numbers[numbers.length - 1] = String(numbers[numbers.length - 1]) + num;
      } else if (numbers[numbers.length - 1] != "0") {
        numbers[numbers.length - 1] = String(
          Number(numbers[numbers.length - 1]) * 10 + Number(num)
        );
      }
    }

    if (numbers[numbers.length - 1] == "0" && num != ".") {
      numbers[numbers.length - 1] = num;
    } else if (num == ".") {
      //맨 끝이 . 으로 끝나는지 check
      numbers[numbers.length - 1] = String(numbers[numbers.length - 1]) + num;
    } else if (numbers[numbers.length - 1] != "0") {
      numbers[numbers.length - 1] = String(
        Number(numbers[numbers.length - 1]) * 10 + Number(num)
      );
    }
  }
}

// console.log(
//   eval(numbers[0] + operators[0] + numbers[1] + operators[1] + numbers[2])
// );
