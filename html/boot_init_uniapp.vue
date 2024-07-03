<template>
  <view class="content">
    <swiper :indicator-dots="true" :autoplay="false" :duration="1000" :indicator-width="10"
            indicator-active-color="#fff">
      <swiper-item>
        <view class="img">
          <image src="../../static/1.png" mode=""></image>
        </view>
        <view class="context">
          <view class="tit">
            uniapp开屏轮播
          </view>
          <view class="desc">
            — 前端源码 雪天前端 —
          </view>
        </view>
      </swiper-item>
      <swiper-item>
        <view class="img">
          <image src="../../static/8.png" mode=""></image>
        </view>
        <view class="context">
          <view class="tit">
            一个简单的滑动
          </view>
          <view class="desc">
            — 前端源码 即可使用 —
          </view>
        </view>
      </swiper-item>
      <swiper-item>
        <view class="img">
          <image src="../../static/14.png" mode=""></image>
        </view>
        <view class="context">
          <view class="tit endTxt">
            欢迎使用
          </view>
          <view class="startBtn" @tap="goHome">
            进入应用
          </view>
        </view>
      </swiper-item>
    </swiper>
  </view>
</template>

<script setup>
function goHome() {
  uni.navigateTo({
    url: "/pages/index/index"
  })
}
</script>

<style scoped>
.content {
  width: 100%;
  height: 100vh;
}

swiper {
  height: 100%;
  height: 100vh;
}

swiper-item .img image {
  height: 450rpx;
}

swiper-item .img {
  position: fixed;
  top: 450rpx;
  left: 50%;
  transform: translateX(-50%);
}

.context {
  width: 100%;
  text-align: center;
  position: fixed;
  bottom: 180rpx;
  left: 50%;
  transform: translateX(-50%);
}

.tit {
  font-size: 60rpx;
  color: #ffff00;
  margin-bottom: 20rpx;
}

.endTxt {
  font-size: 60rpx;
  color: #ffffff;

}

.desc {
  font-size: 40rpx;
  color: #ffffff;
  margin-bottom: 20rpx;
}

swiper-item:nth-child(1) {
  height: 100%;
  background-color: rgb(25, 219, 204);
}

swiper-item:nth-child(2) {
  height: 100%;
  background-color: rgb(0, 206, 222);
}

swiper-item:nth-child(3) {
  height: 100%;
  background-color: rgb(146, 147, 240);
}

/* 这里无法兼容 需要分开写 */
/* #ifdef MP-WEIXIN */
::v-deep .wx-swiper-dots {
  bottom: 100rpx !important;
}

::v-deep .wx-swiper-dot-active {
  width: 50rpx;
  border-radius: 50rpx;
}

/* #endif */

::v-deep .uni-swiper-dots-horizontal {
  bottom: 100rpx !important;
}

.startBtn {
  width: 355rpx;
  line-height: 80rpx;
  text-align: center;
  font-size: 30rpx;
  color: #000000;
  background-color: rgba(255, 255, 255, 1);
  border-radius: 40rpx;
  margin: 20rpx auto;
  letter-spacing: 10rpx;
  margin-top: 60rpx;
}
</style>