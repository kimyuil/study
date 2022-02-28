const numButtons = document.getElementsByClassName("num");
const opButtons = document.getElementsByClassName("operator");
const operateButton = document.getElementById("operate");

class StackYuil {
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
  get(i){
    return this.arr[i]
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
var expression = new StackYuil();

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
  let inputBox = document.getElementsByClassName("inputLine");

  let operatorStack = new StackYuil();
  let convertStack = new StackYuil();
  let calculateStack = new StackYuil();  
  let temp = "";

  console.log(inputBox[0].innerHTML)

  const f = inputBox[0].innerHTML; //식

  console.log("start!!!!!")
  for(let i = 0; i<f.length; i++) {
    console.log(operatorStack.toString(), " / " ,convertStack.toString())
      const char = f.charAt(i);
      
      switch(char) {
          case '(' :                
              operatorStack.push(char);
              break;

          case '+' : case '-' : case '×' : case '/' :
              while(operatorStack.peek() != null &&
                  prec(char) <= prec(operatorStack.peek()) ){
                    convertStack.push(operatorStack.pop());
              } 
              operatorStack.push(char);
              break;

          case ')' :
            
            let loop = true;
            while(loop){
              let returned_op = operatorStack.pop();
              if( returned_op === "("){
                loop = false;
                continue;
              }
              convertStack.push(returned_op)
            }                
            break;

          default :
            temp += char; // isNaN(f.charAt(i+1)) : 다음에 연산자가 나오면
            if(isNaN(f.charAt(i+1)) || ( (i+1) == f.length )){
              if(f.charAt(i+1) == '.'){   //소수점처리
                continue;
              } else {
                convertStack.push(temp);
                temp="";
              }
            }
            break;
      }
      
  }
    
  while(operatorStack.peek() != null){
    convertStack.push(operatorStack.pop());
  }    
  console.log(convertStack.toString())

  for(let i = 0 ; i < convertStack.length() ; i++){
    if(!isNaN(convertStack.get(i))){
      //숫자일때
      calculateStack.push(convertStack.get(i))
    }else{
      //연산자일때
      const b = parseFloat(calculateStack.pop());
        const a = parseFloat(calculateStack.pop());

        switch(convertStack.get(i)){ // 계산해서 다시 stack에 넣기
          case '+' : calculateStack.push(a+b);
            break;
          
          case '-' : calculateStack.push(a-b);
            break;

          case '×' : calculateStack.push(a*b);
            break;

          case '/' : calculateStack.push(a/b);
            break;
        }
      }
    }
  
    document.getElementsByClassName("output")[0].innerHTML = calculateStack.pop()

  
    // 꼼수의 방법

  // let result = eval(expression.toString());
  // if (isInt(result)) {
  //   outputBox[0].innerHTML = result;
  // } else {
  //   let tmpResult = String(parseFloat(result).toFixed(15))
  //   let complete 
  //   while(true){
  //     if(tmpResult.substring(tmpResult.length-1,tmpResult.length) == '0'){
  //       tmpResult = tmpResult.slice(0,tmpResult.length-1)
  //     }else{
  //       complete = tmpResult
  //       break;
  //     }
  //   }    
  //   outputBox[0].innerHTML = complete;
  // }
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

// new ----------- 2022 palm ------------------

function prec(op) {
  switch(op) {
      case '(':
      case ')':
          return 0;
      case '+':
      case '-':
          return 1;
      case '×':
      case '/':
          return 2;    
      }
      return 999;
}
