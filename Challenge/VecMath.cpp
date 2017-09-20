#include <cmath>
#include "VecMath.h"


// vector3
float vector3::operator[](int i) const {
	return (&x)[i];
}

float& vector3::operator[](int i) {
	return (&x)[i];
}

bool vector3::operator==(const vector3 &v) const {
	return x==v.x && y==v.y && z==v.z;
}

vector3 vector3::operator+=(const vector3 &v) {
	// *this = *this + v;
	x += v.x;
	y += v.y;
	z += v.z;
	return *this;
}

vector3 vector3::operator*=(float s) {
	// *this = *this * s;
	x *= s;
	y *= s;
	z *= s;
	return *this;
}

vector3 vector3::operator/=(float s) {
	// *this = *this * (1.0f / s);
	float r = 1.0f / s;
	x *= s;
	y *= s;
	z *= s;
	return *this;
}

float vector3::Length()
{
	return sqrt(x*x + y*y + z*z);
}


vector3 operator+(const vector3 &v0, const vector3 &v1)
{
	return vector3(v0.x + v1.x, v0.y + v1.y, v0.z + v1.z);
}

vector3 operator-(const vector3 &v0, const vector3 &v1)
{
	return vector3(v0.x - v1.x, v0.y - v1.y, v0.z - v1.z);
}

vector3 operator*(const vector3 &v0, const vector3 &v1)
{
	return vector3(v0.x * v1.x, v0.y * v1.y, v0.z * v1.z);
}

vector3 operator*(const vector3 &v, float s)
{
	return vector3(v.x * s, v.y * s, v.z * s);
}

vector3 operator*(float s, const vector3 &v)
{
	return v * s;
}

vector3 operator/(const vector3 &v, float s)
{
	return v * (1.0f / s);
}

float dot(const vector3 &v0, const vector3 &v1)
{
	return v0.x * v1.x + v0.y * v1.y + v0.z * v1.z;
}

vector3 cross(const vector3 &v0, const vector3 &v1)
{
	return vector3(v0.y * v1.z - v0.z * v1.y, v0.z * v1.x - v0.x * v1.z, v0.x * v1.y - v0.y * v1.x);
}

float norm(const vector3 &v)
{
	return sqrt(dot(v, v));
}

vector3 unit(const vector3 &v)
{
	return v / norm(v);
}

vector3 operator-(const vector3 &v)
{
	return vector3(-v.x, -v.y, -v.z);
}


