//EventEmitter
// Node.js 所有的异步 I/O 操作在完成时都会发送一个事件到  事件队列。
// 许多对象都会分发事件：一个 net.Server 对象会在每次有新连接时触发一个事件， 一个 fs.readStream 对象会在文件被打开的时候触发一个事件。 所有这些产生事件的对象都是 events.EventEmitter 的实例。

// events 模块只提供了一个对象： events.EventEmitter。
// EventEmitter 的核心就是事件触发与事件监听器功能的封装。

//EventEmitter发生错误:触发err
//eventEmitter.js 文件
// var EventEmitter = require('events').EventEmitter;
// var event = new EventEmitter();
// event.on('some_event', function() {
//     console.log('some_event 事件触发');
// });
// setTimeout(function() {
//     event.emit('some_event');
// }, 1000);


// EventEmitter 的每个事件由一个事件名和若干个参数组成，事件名是一个字符串，通常表达一定的语义。对于每个事件，EventEmitter 支持 若干个事件监听器。
// 当事件触发时，注册到这个事件的事件监听器被依次调用，事件参数作为回调函数参数传递。
//eventEmitter.js 文件
var events = require('events');
var emitter = new events.EventEmitter();
//someEvent 绑定了两个事件监听器,触发的时候依次执行!
emitter.on('someEvent', function(arg1, arg2) {
    console.log('listener1', arg1, arg2);
});
emitter.on('someEvent', function(arg1, arg2) {
    console.log('listener2', arg1, arg2);
});
emitter.emit('someEvent', 'arg1 参数', 'arg2 参数');
//result
// listener1 arg1 参数 arg2 参数
// listener2 arg1 参数 arg2 参数

//方法介绍
//addListener(event, listener)  为指定事件添加一个监听器到监听器数组的尾部。

//on(event, listener)   为指定事件注册一个监听器，接受一个字符串 event 和一个回调函数。
//         server.on('connection', function (stream) {
//             console.log('someone connected!');
//         });

// once(event, listener)  为指定事件注册一个单次监听器，即 监听器最多只会触发一次，触发后立刻解除该监听器
//         server.once('connection', function (stream) {
//             console.log('Ah, we have our first user!');
//         });

// removeListener(event, listener) 移除指定事件的某个监听器，监听器必须是该事件已经注册过的监听器。
// 它接受两个参数，第一个是事件名称，第二个是回调函数名称。
//         var callback = function(stream) {
//             console.log('someone connected!');
//         };
//         server.on('connection', callback);
//         // ...
//         server.removeListener('connection', callback);

// removeAllListeners([event])  移除所有事件的所有监听器， 如果指定事件，则移除指定事件的所有监听器。

//setMaxListeners(n) 默认情况下， EventEmitters 如果你添加的监听器超过 10 个就会输出警告信息。
// setMaxListeners 函数用于提高监听器的默认限制的数量。

// listeners(event)  返回指定事件的监听器数组。

//emit(event, [arg1], [arg2], [...])  按监听器的顺序执行执行每个监听器，如果事件有注册监听返回 true，否则返回 false。

// 类方法
// listenerCount(emitter, event)  返回指定事件的监听器数量。
// events.EventEmitter.listenerCount(emitter, eventName) //已废弃，不推荐
// events.emitter.listenerCount(eventName) //推荐

//事件
// newListener
//         event - 字符串，事件名称
//         listener - 处理事件函数
// 该事件在添加新监听器时被触发。

// removeListener
//         event - 字符串，事件名称
//         listener - 处理事件函数
// 从指定监听器数组中删除一个监听器。需要注意的是，此操作将会改变处于被删监听器之后的那些监听器的索引。

// main.js
// require


// error 事件
// var events1 = require('events');
// var emitter1 = new events1.EventEmitter();
// emitter1.emit('error');

// 继承 EventEmitter
// 大多数时候我们不会直接使用 EventEmitter，而是在对象中继承它。包括 fs、net、 http 在内的，只要是支持事件响应的核心模块都是 EventEmitter 的子类。
