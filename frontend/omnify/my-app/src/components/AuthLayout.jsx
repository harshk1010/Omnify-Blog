import React from "react";

export default function AuthLayout({ children, bgClass }) {
  return (
    <div className={`h-screen flex items-center justify-center ${bgClass}`}>
      <div className="bg-white/90 backdrop-blur-lg p-8 rounded-2xl shadow-xl w-full max-w-md">
        {children}
      </div>
    </div>
  );
}
