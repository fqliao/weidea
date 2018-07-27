// 全局变量
let globalData = {}
export default {
	install(Vue, options) {
		Vue.prototype.getData = (key) => {
			return globalData[key]
		}
		Vue.prototype.setData = (key, value) => {
			globalData[key] = value
		}
	}
}