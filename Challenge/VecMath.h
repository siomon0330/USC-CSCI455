#ifndef AIMLIB2_H
#define AIMLIB2_H

#include <iostream>

// const
const float pi = 3.14159265f;

// vector3
struct vector3 {
	float x, y, z;

	vector3()
	{}
	vector3(float _x, float _y, float _z)
		: x(_x), y(_y), z(_z)
	{}
	float operator[](int i) const;
	float& operator[](int i);
	bool operator==(const vector3 &v) const;
	vector3 operator+=(const vector3 &v);
	vector3 operator*=(float s);
	vector3 operator/=(float s);

	float Length();
};
struct matrix33 {
	vector3 x, y, z;

	matrix33()
	{}
	matrix33(const vector3 &_x, const vector3 &_y, const vector3 &_z)
		: x(_x), y(_y), z(_z)
	{}
};

// vector ops
vector3 operator-(const vector3 &v);
vector3 operator+(const vector3 &v0, const vector3 &v1);
vector3 operator-(const vector3 &v0, const vector3 &v1);
vector3 operator*(const vector3 &v0, const vector3 &v1);
vector3 operator*(const vector3 &v, float s);
vector3 operator*(float s, const vector3 &v);
vector3 operator/(const vector3 &v, float s);

float dot(const vector3 &v0, const vector3 &v1);
vector3 cross(const vector3 &v0, const vector3 &v1);
vector3 reflect(const vector3 &v, const vector3 &n);
float norm(const vector3 &v);
vector3 unit(const vector3 &v);


#endif // AIMLIB2_H