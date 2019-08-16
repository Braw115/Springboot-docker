include rules.mk

all: echo-env check-env pitaka-web
install: pitaka-web-install
image: pitaka-web-image

.PHONY: clean
clean: pitaka-web-clean

echo-env:
	@echo "TARGET_DIR=$(TARGET_DIR)"
	@echo "TAG_VERSION=$(TAG_VERSION)"
	@echo "REGISTRY=$(REGISTRY)"

check-env:
	@if [ "$(TARGET_DIR)" = "" ]; then echo "ERROR: TARGET_DIR was not set"; exit 1; fi
	@if [ "$(TAG_VERSION)" = "" ]; then echo "ERROR: TAG_VERSION was not set"; exit 1; fi
	@if [ "$(REGISTRY)" = "" ]; then echo "ERROR: REGISTRY was not set"; exit 1install; fi

#编译打jar包
.PHONY: pitaka-web
pitaka-web:
	mvn clean package -Dmaven.test.skip=true

#文件安装复制
pitaka-web-install:
	rm -rf $(TARGET_DIR)
	mkdir -p $(TARGET_DIR)
	cp -r $(BUILD_ROOT)/pitaka-web/target/pitaka-web-1.0.0.jar $(BUILD_ROOT)/pitaka-web/src/main/docker/* $(TARGET_DIR)/

#打包镜像
pitaka-web-image:check-env
	
	cd $(TARGET_DIR) && sudo docker build . -t $(REGISTRY)/pitaka-web:$(TAG_VERSION)

#清除
pitaka-web-clean:
	mvn clean -Dmaven.test.skip=true
	rm -rf $(TARGET_DIR)









