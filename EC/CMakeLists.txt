cmake_minimum_required(VERSION 3.7)
project(EC)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES ectest.cpp ecListFuncs.cpp ecListFuncs.h)
add_executable(EC ${SOURCE_FILES})