#pragma checksum "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Login.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "7b0c9baea6f4397ece8506bd7206d98e4f943ee8"
// <auto-generated/>
#pragma warning disable 1591
namespace WebApplication.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Web.Virtualization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using WebApplication;

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using WebApplication.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Login.razor"
using WebApplication.Auth;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/Login")]
    public partial class Login : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.OpenElement(0, "div");
            __builder.AddAttribute(1, "class", "flex justify-center  w-full pt-10 ");
            __builder.AddAttribute(2, "b-t8mfqvmzkk");
            __builder.OpenElement(3, "div");
            __builder.AddAttribute(4, "class", "loginForm ");
            __builder.AddAttribute(5, "b-t8mfqvmzkk");
#nullable restore
#line 10 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Login.razor"
         if (_errorMessage != null)
        {

#line default
#line hidden
#nullable disable
            __builder.OpenElement(6, "div");
            __builder.AddAttribute(7, "class", "mb-2 failedLogin p-3 rounded-lg");
            __builder.AddAttribute(8, "b-t8mfqvmzkk");
            __builder.OpenElement(9, "p");
            __builder.AddAttribute(10, "b-t8mfqvmzkk");
            __builder.AddContent(11, 
#nullable restore
#line 13 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Login.razor"
                     _errorMessage

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.CloseElement();
#nullable restore
#line 15 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Login.razor"
        }

#line default
#line hidden
#nullable disable
            __builder.OpenElement(12, "div");
            __builder.AddAttribute(13, "class", "mb-2 p-3 bg-gray-100 rounded-lg");
            __builder.AddAttribute(14, "b-t8mfqvmzkk");
            __builder.OpenElement(15, "div");
            __builder.AddAttribute(16, "class", "p-2");
            __builder.AddAttribute(17, "b-t8mfqvmzkk");
            __builder.OpenElement(18, "p");
            __builder.AddAttribute(19, "b-t8mfqvmzkk");
            __builder.OpenElement(20, "input");
            __builder.AddAttribute(21, "class", "bg-gray-100 w-full p-2 rounded-lg border-0 ");
            __builder.AddAttribute(22, "type", "text");
            __builder.AddAttribute(23, "placeholder", "Email");
            __builder.AddAttribute(24, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 19 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Login.razor"
                                                                                                                            _email

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(25, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => _email = __value, _email));
            __builder.SetUpdatesAttributeName("value");
            __builder.AddAttribute(26, "b-t8mfqvmzkk");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(27, "\r\n            ");
            __builder.OpenElement(28, "div");
            __builder.AddAttribute(29, "class", "p-2");
            __builder.AddAttribute(30, "b-t8mfqvmzkk");
            __builder.OpenElement(31, "p");
            __builder.AddAttribute(32, "b-t8mfqvmzkk");
            __builder.OpenElement(33, "input");
            __builder.AddAttribute(34, "class", "bg-gray-100 w-full p-2 rounded-lg border-0 ");
            __builder.AddAttribute(35, "type", "password");
            __builder.AddAttribute(36, "placeholder", "Password");
            __builder.AddAttribute(37, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 24 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Login.razor"
                                                                                                                                   _password

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(38, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => _password = __value, _password));
            __builder.SetUpdatesAttributeName("value");
            __builder.AddAttribute(39, "b-t8mfqvmzkk");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(40, "\r\n            ");
            __builder.OpenElement(41, "div");
            __builder.AddAttribute(42, "class", "p-2 flex justify-evenly");
            __builder.AddAttribute(43, "b-t8mfqvmzkk");
            __builder.OpenElement(44, "button");
            __builder.AddAttribute(45, "class", "btn btn-outline-dark w-full hover:bg-blue-700");
            __builder.AddAttribute(46, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 28 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Login.razor"
                                                                                        PerformLogin

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(47, "type", "submit");
            __builder.AddAttribute(48, "b-t8mfqvmzkk");
            __builder.AddContent(49, "Login");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(50, "\r\n        ");
            __builder.OpenElement(51, "div");
            __builder.AddAttribute(52, "class", "p-3 bg-white rounded-lg");
            __builder.AddAttribute(53, "b-t8mfqvmzkk");
            __builder.OpenElement(54, "p");
            __builder.AddAttribute(55, "b-t8mfqvmzkk");
            __builder.AddMarkupContent(56, "\r\n                New to the website? ");
            __builder.OpenElement(57, "button");
            __builder.AddAttribute(58, "class", "link");
            __builder.AddAttribute(59, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 33 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Login.razor"
                                                                     () => NavManager.NavigateTo("/register")

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(60, "b-t8mfqvmzkk");
            __builder.AddContent(61, " Create an Account.");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
        }
        #pragma warning restore 1998
#nullable restore
#line 39 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Login.razor"
       
    private string _email;
    private string _password;
    private string _errorMessage;

    public async Task PerformLogin()
    {
        try
        {
            await ((CustomAuthenticationStateProvider) AuthenticationStateProvider).ValidateLogin(_email, _password);
            _email = "";
            _errorMessage = "";
            _password = "";
            NavManager.NavigateTo("/");
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            _errorMessage = e.Message;
        }
    }


#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager NavManager { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private AuthenticationStateProvider AuthenticationStateProvider { get; set; }
    }
}
#pragma warning restore 1591
