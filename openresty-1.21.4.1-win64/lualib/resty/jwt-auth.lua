ngx.log(ngx.STDERR, 'this is a log string from lua')
local jwt = require "resty.jwt"
local validators = require "resty.jwt-validators"
local json = require('cjson')
function dump(o)
   if type(o) == 'table' then
      local s = '{ '
      for k,v in pairs(o) do
         if type(k) ~= 'number' then k = '"'..k..'"' end
         s = s .. '['..k..'] = ' .. dump(v) .. ','
      end
      return s .. '} '
   else
      return tostring(o)
   end
end
if ngx.var.request_method ~= "OPTIONS" and not string.match(ngx.var.uri, "sign") then
	local jwtToken = ngx.var.http_Authorization
	if jwtToken == nil then
		ngx.status = ngx.HTTP_UNAUTHORIZED
		ngx.header.content_type = "application/json; charset=utf-8"
		ngx.say("{\"error\": \"Forbidden\"}")
		ngx.exit(ngx.HTTP_UNAUTHORIZED)
	end
	local claim_spec = {
		sub = function(val) return string.match("^[a-z]+$", val) end,
	}
	local jwt_obj = jwt:verify('qHO^4L09T2P*1doggRz^k#yHQMFmgfYS', jwtToken, claim_spec)
	if not jwt_obj["verified"] then
		ngx.log(ngx.STDERR, 'this is a log string from lua2')
		ngx.status = ngx.HTTP_UNAUTHORIZED
		ngx.header.content_type = "application/json; charset=utf-8"
		ngx.say("{\"error\": \"INVALID_JWT\"}")
		ngx.exit(ngx.HTTP_UNAUTHORIZED)
	end
end