var fs = require("fs");

// fs.readFile() 异步函数用于读取文件
// 如果在读取文件过程中发生错误，错误 err 对象就会输出错误信息。
fs.readFile('input.txt', function (err, data) {
    if (err){
        console.log(err.stack);
        return;
    }
    console.log(data.toString());
});
console.log("程序执行完毕");
