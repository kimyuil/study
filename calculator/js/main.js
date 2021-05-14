const numButtons = document.getElementsByClassName("num");
const opButtons = document.getElementsByClassName("operator");
const operateButton = document.getElementById("operate");

class StackExp {
  constructor() {
    this.arr = [];
    this.index = 0;
  }
  push(item) {
    this.arr[this.index++] = item;
  }
  pop() {
    if (this.index <= 0) return null;
    const result = this.arr[--this.index];
    return result;
  }
  peek(){
    return this.arr[this.index-1]
  }
  toString(){
    let finalExpression = "";
    for (let i = 0; i < this.index; i++) {
      finalExpression += this.arr[i];
    }
    return finalExpression;
  }
  length(){
    return this.index
  }
  clean(){
    this.arr=[]
    this.index=0
  }
  info(){
    console.log(this.arr)
    console.log(this.index)
  }
  isPuttingFloat(){
    if(this.length()==1 || isOperator(this.peek())){
      return false
    }else{
      let tempArr = this.arr.slice()
      let data = []
      for(let i = this.index-1 ; i >= 0 ; i --){
        let temp = tempArr.pop()
        if(isOperator(temp)){
          break;
        }else{
          data.push(temp)
        }
      }
      if(data.indexOf(".")==-1){
        return false
      }else{
        return true
      }      
    }
  }
}
var expression = new StackExp();

Object.values(numButtons).forEach((btn) => {
  let val = btn.dataset.num;
  btn.addEventListener("click", () => {
    // putNum(val);
    putNum(val);
  });
});

Object.values(opButtons).forEach((btn) => {
  let val = btn.dataset.op;
  btn.addEventListener("click", () => {
    putOp(val);
  });
});

operateButton.addEventListener("click", () => {
  let outputBox = document.getElementsByClassName("output");
  let result = eval(expression.toString());
  if (isInt(result)) {
    outputBox[0].innerHTML = result;
  } else {
    let tmpResult = String(parseFloat(result).toFixed(15))
    let complete 
    while(true){
      if(tmpResult.substring(tmpResult.length-1,tmpResult.length) == '0'){
        tmpResult = tmpResult.slice(0,tmpResult.length-1)
      }else{
        complete = tmpResult
        break;
      }
    }    
    outputBox[0].innerHTML = complete;
  }
});

function putNum(num) {
  if (expression.peek() == "." && num == ".") {

  } else if (expression.peek() == "0" && num == "0" && !expression.isPuttingFloat()) {

  } else if (
    expression.peek() == "0" &&
    Number(num) > 0 &&
    Number(num) < 10 &&
    !expression.isPuttingFloat()
  ) {
    //error (float)
    expression.pop()
    expression.push(num)
  } else if (expression.peek() == "-" && num == ".") {
    expression.push("0");
    expression.push(".");
  } else if (expression.isPuttingFloat() && num == "."){

  }else {
    expression.push(num);
  }

  drawExpression();
}

function putOp(op) {
  if (op == "clear") {
    expression.clean();
    document.getElementsByClassName("output")[0].innerHTML = "";
  } else if(op == "del"){
    expression.pop()
  }
  else if (isOperator(expression.peek()) && isOperator(op)) {
    expression.pop()
    expression.push(op)
  } else if (op == "bracket") {
    alert("sorry");
  } else {
    expression.push(op);
  }

  drawExpression();
}

function drawExpression() {
  let inputBox = document.getElementsByClassName("inputLine");
  inputBox[0].innerHTML = expression.toString();
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