//Node.js 全局对象

// JavaScript 中有一个特殊的对象，称为全局对象（Global Object），它及其所有属性都可以在程序的任何地方访问，即全局变量。
// js中window是全局对象,node中的全局对象是global,所有全局变量都是global对象的属性!

// 按照ECMAScript的定义,满足以下条件的变量是全局变量
// 在最外层定义的变量；
// 全局对象的属性；
// 隐式定义的变量（未定义直接赋值的变量）。

//注意:: 最好不要使用 var 定义变量以避免引入全局变量，因为全局变量会污染命名空间，提高代码的耦合风险。
//全局对象
console.log( __dirname);

console.log( __filename);

function printHello(){
    console.log( "Hello, World start!");
}
// 两秒后执行以上函数
// setTimeout(printHello, 2000);
// console.log( "Hello, World  end!");
// // 清除定时器
// clearTimeout(printHello);

//循环
// 两秒后执行以上函数
setInterval(printHello, 1000);
// 清除循环
clearInterval(printHello);  //参数t

//process 全局变量     Node.js 进程状态
//
// stdout: //标准输出流。
// stderr  //标准错误流。
// stdin    //标准输入流。
// argv  //argv 属性返回一个数组，由命令行执行脚本时的各个参数组成。它的第一个成员总是node，第二个成员是脚本文件名，其余成员是脚本文件的参数。
// execPath  //返回执行当前脚本的 Node 二进制文件的绝对路径。
// execArgv  //返回一个数组，成员是命令行下执行脚本时，在Node可执行文件与脚本文件之间的命令行参数。
// env   //返回一个对象，成员为当前 shell 的环境变量
// exitCode   //进程退出时的代码，如果进程优通过 process.exit() 退出，不需要指定退出码。
// version  //Node 的版本，比如v0.10.18。
// versions  //一个属性，包含了 node 的版本和依赖.
// config  //一个包含用来编译当前 node 执行文件的 javascript 配置选项的对象。它与运行 ./configure 脚本生成的 "config.gypi" 文件相同。
// pid  //当前进程的进程号。
// title  //进程名，默认值为"node"，可以自定义该值。
// arch 当前 CPU 的架构：'arm'、'ia32' 或者 'x64'。
// platform  //运行程序所在的平台系统 'darwin', 'freebsd', 'linux', 'sunos' 或 'win32'
// mainModule//require.main 的备选方法。不同点，如果主模块在运行时改变，require.main可能会继续返回老的模块。可以认为，这两者引用了同一个模块。

