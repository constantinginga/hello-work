#pragma checksum "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "e8cf67c7ac01c84996340e344bc2f3bd35ba1ee4"
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
#line 2 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
using WebApplication.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
using WebApplication.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
using WebApplication.Auth;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/joblisting/create")]
    public partial class CreateJobListing : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.OpenElement(0, "body");
            __builder.AddAttribute(1, "b-ppjh64qbg9");
            __builder.OpenComponent<Microsoft.AspNetCore.Components.Forms.EditForm>(2);
            __builder.AddAttribute(3, "Model", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Object>(
#nullable restore
#line 10 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                  jobListing

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(4, "OnValidSubmit", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<Microsoft.AspNetCore.Components.Forms.EditContext>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Forms.EditContext>(this, 
#nullable restore
#line 10 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                              CreateNewJobListing

#line default
#line hidden
#nullable disable
            )));
            __builder.AddAttribute(5, "ChildContent", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Forms.EditContext>)((context) => (__builder2) => {
                __builder2.AddMarkupContent(6, "<div class=\"title\" b-ppjh64qbg9>Create job listing</div>\r\n    ");
                __builder2.OpenElement(7, "div");
                __builder2.AddAttribute(8, "class", "form-group");
                __builder2.AddAttribute(9, "b-ppjh64qbg9");
                __builder2.OpenElement(10, "div");
                __builder2.AddAttribute(11, "class", "details");
                __builder2.AddAttribute(12, "b-ppjh64qbg9");
                __builder2.OpenElement(13, "div");
                __builder2.AddAttribute(14, "class", "form-row");
                __builder2.AddAttribute(15, "b-ppjh64qbg9");
                __builder2.OpenElement(16, "div");
                __builder2.AddAttribute(17, "class", "input-box");
                __builder2.AddAttribute(18, "b-ppjh64qbg9");
                __builder2.AddMarkupContent(19, "<label b-ppjh64qbg9>Job title</label>\r\n                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(20);
                __builder2.AddAttribute(21, "class", "form-control");
                __builder2.AddAttribute(22, "placeholder", "Job title");
                __builder2.AddAttribute(23, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 18 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                                                         jobListing.JobTitle

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(24, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => jobListing.JobTitle = __value, jobListing.JobTitle))));
                __builder2.AddAttribute(25, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => jobListing.JobTitle));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(26, "\r\n                ");
                __builder2.OpenElement(27, "div");
                __builder2.AddAttribute(28, "class", "input-box");
                __builder2.AddAttribute(29, "b-ppjh64qbg9");
                __builder2.AddMarkupContent(30, "<label b-ppjh64qbg9>Job type</label>\r\n                    ");
                __builder2.OpenElement(31, "select");
                __builder2.AddAttribute(32, "class", "custom-select filter-property");
                __builder2.AddAttribute(33, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.ChangeEventArgs>(this, 
#nullable restore
#line 23 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                                               (arg) => SetJobType(arg)

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(34, "b-ppjh64qbg9");
                __builder2.OpenElement(35, "option");
                __builder2.AddAttribute(36, "selected");
                __builder2.AddAttribute(37, "disabled");
                __builder2.AddAttribute(38, "b-ppjh64qbg9");
                __builder2.AddContent(39, "Select property");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(40, "\r\n                        ");
                __builder2.OpenElement(41, "option");
                __builder2.AddAttribute(42, "b-ppjh64qbg9");
                __builder2.AddContent(43, 
#nullable restore
#line 25 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                 JobSchedule.ToDescription(@JobSchedule.Schedule.FullTime)

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(44, "\r\n                        ");
                __builder2.OpenElement(45, "option");
                __builder2.AddAttribute(46, "b-ppjh64qbg9");
                __builder2.AddContent(47, 
#nullable restore
#line 26 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                 JobSchedule.ToDescription(@JobSchedule.Schedule.PartTime)

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(48, "\r\n                        ");
                __builder2.OpenElement(49, "option");
                __builder2.AddAttribute(50, "b-ppjh64qbg9");
                __builder2.AddContent(51, 
#nullable restore
#line 27 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                 JobSchedule.ToDescription(@JobSchedule.Schedule.Internship)

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(52, "\r\n                        ");
                __builder2.OpenElement(53, "option");
                __builder2.AddAttribute(54, "b-ppjh64qbg9");
                __builder2.AddContent(55, 
#nullable restore
#line 28 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                 JobSchedule.ToDescription(@JobSchedule.Schedule.Volunteering)

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(56, "\r\n            ");
                __builder2.OpenElement(57, "div");
                __builder2.AddAttribute(58, "class", "form-row");
                __builder2.AddAttribute(59, "b-ppjh64qbg9");
                __builder2.OpenElement(60, "div");
                __builder2.AddAttribute(61, "class", "input-box");
                __builder2.AddAttribute(62, "b-ppjh64qbg9");
                __builder2.AddMarkupContent(63, "<label b-ppjh64qbg9>Location</label>\r\n                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(64);
                __builder2.AddAttribute(65, "class", "form-control");
                __builder2.AddAttribute(66, "placeholder", "Location");
                __builder2.AddAttribute(67, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 35 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                                                        jobListing.Location

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(68, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => jobListing.Location = __value, jobListing.Location))));
                __builder2.AddAttribute(69, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => jobListing.Location));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(70, "\r\n                ");
                __builder2.OpenElement(71, "div");
                __builder2.AddAttribute(72, "class", "input-box calendar");
                __builder2.AddAttribute(73, "b-ppjh64qbg9");
                __builder2.AddMarkupContent(74, "<label b-ppjh64qbg9>Deadline</label>\r\n                    ");
                __Blazor.WebApplication.Pages.CreateJobListing.TypeInference.CreateInputDate_0(__builder2, 75, 76, "form-control", 77, 
#nullable restore
#line 39 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                            ApplicationDate

#line default
#line hidden
#nullable disable
                , 78, Microsoft.AspNetCore.Components.EventCallback.Factory.Create(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => ApplicationDate = __value, ApplicationDate)), 79, () => ApplicationDate);
                __builder2.CloseElement();
                __builder2.AddMarkupContent(80, "\r\n                ");
                __builder2.OpenElement(81, "div");
                __builder2.AddAttribute(82, "class", "experience-level");
                __builder2.AddAttribute(83, "b-ppjh64qbg9");
                __builder2.AddMarkupContent(84, "<label b-ppjh64qbg9>Experience level</label>\r\n                    ");
                __Blazor.WebApplication.Pages.CreateJobListing.TypeInference.CreateInputNumber_1(__builder2, 85, 86, "0", 87, "form-control", 88, "Experience level", 89, 
#nullable restore
#line 43 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                                                                          jobListing.ExperienceLevel

#line default
#line hidden
#nullable disable
                , 90, Microsoft.AspNetCore.Components.EventCallback.Factory.Create(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => jobListing.ExperienceLevel = __value, jobListing.ExperienceLevel)), 91, () => jobListing.ExperienceLevel);
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(92, "\r\n            ");
                __builder2.OpenElement(93, "div");
                __builder2.AddAttribute(94, "class", "form-row");
                __builder2.AddAttribute(95, "b-ppjh64qbg9");
                __builder2.OpenElement(96, "div");
                __builder2.AddAttribute(97, "class", "input-box");
                __builder2.AddAttribute(98, "b-ppjh64qbg9");
                __builder2.AddMarkupContent(99, "<label b-ppjh64qbg9>Email</label>\r\n                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(100);
                __builder2.AddAttribute(101, "class", "form-control");
                __builder2.AddAttribute(102, "placeholder", "Email");
                __builder2.AddAttribute(103, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 49 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                                                     jobListing.Email

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(104, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => jobListing.Email = __value, jobListing.Email))));
                __builder2.AddAttribute(105, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => jobListing.Email));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(106, "\r\n\r\n                ");
                __builder2.OpenElement(107, "div");
                __builder2.AddAttribute(108, "class", "input-box");
                __builder2.AddAttribute(109, "b-ppjh64qbg9");
                __builder2.AddMarkupContent(110, "<label b-ppjh64qbg9>Phone number</label>\r\n                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(111);
                __builder2.AddAttribute(112, "class", "form-control");
                __builder2.AddAttribute(113, "placeholder", "Phone Number");
                __builder2.AddAttribute(114, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 54 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                                                            jobListing.PhoneNumber

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(115, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => jobListing.PhoneNumber = __value, jobListing.PhoneNumber))));
                __builder2.AddAttribute(116, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => jobListing.PhoneNumber));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(117, "\r\n            ");
                __builder2.OpenElement(118, "div");
                __builder2.AddAttribute(119, "class", "input-box");
                __builder2.AddAttribute(120, "b-ppjh64qbg9");
                __builder2.OpenElement(121, "div");
                __builder2.AddAttribute(122, "class", "job-req-header");
                __builder2.AddAttribute(123, "b-ppjh64qbg9");
                __builder2.OpenElement(124, "p");
                __builder2.AddAttribute(125, "b-ppjh64qbg9");
                __builder2.AddContent(126, "Job requirements ");
                __builder2.OpenElement(127, "span");
                __builder2.AddAttribute(128, "b-ppjh64qbg9");
                __builder2.AddContent(129, 
#nullable restore
#line 59 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                               jobRequirements.Count

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(130, "\r\n                    ");
                __builder2.OpenElement(131, "button");
                __builder2.AddAttribute(132, "class", "job-req-btn");
                __builder2.AddAttribute(133, "type", "button");
                __builder2.AddAttribute(134, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 60 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                                        (() => AddJobReq())

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(135, "b-ppjh64qbg9");
                __builder2.AddContent(136, "+");
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(137, "\r\n                ");
                __builder2.OpenElement(138, "div");
                __builder2.AddAttribute(139, "class", "job-req-container");
                __builder2.AddAttribute(140, "b-ppjh64qbg9");
#nullable restore
#line 63 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                     foreach (var element in jobRequirements.Select((e, i) => new {Effect = e, Index = i}))
                    {

#line default
#line hidden
#nullable disable
                __builder2.OpenElement(141, "input");
                __builder2.AddAttribute(142, "class", "form-control");
                __builder2.AddAttribute(143, "id", 
#nullable restore
#line 65 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                          $"effect{element.Index}"

#line default
#line hidden
#nullable disable
                );
                __builder2.AddAttribute(144, "value", 
#nullable restore
#line 65 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                                                             element.Effect

#line default
#line hidden
#nullable disable
                );
                __builder2.AddAttribute(145, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.ChangeEventArgs>(this, 
#nullable restore
#line 66 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                            e => jobRequirements[element.Index] = e.Value.ToString()

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(146, "placeholder", "Job Requirement");
                __builder2.AddAttribute(147, "b-ppjh64qbg9");
                __builder2.CloseElement();
#nullable restore
#line 67 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                    }

#line default
#line hidden
#nullable disable
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(148, "\r\n            ");
                __builder2.OpenElement(149, "div");
                __builder2.AddAttribute(150, "class", "input-box");
                __builder2.AddAttribute(151, "b-ppjh64qbg9");
                __builder2.OpenElement(152, "div");
                __builder2.AddAttribute(153, "class", "job-prv-header");
                __builder2.AddAttribute(154, "b-ppjh64qbg9");
                __builder2.OpenElement(155, "p");
                __builder2.AddAttribute(156, "b-ppjh64qbg9");
                __builder2.AddContent(157, "Job privileges ");
                __builder2.OpenElement(158, "span");
                __builder2.AddAttribute(159, "b-ppjh64qbg9");
                __builder2.AddContent(160, 
#nullable restore
#line 72 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                             jobPrivilleges.Count

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(161, "\r\n                    ");
                __builder2.OpenElement(162, "button");
                __builder2.AddAttribute(163, "class", "job-prv-btn");
                __builder2.AddAttribute(164, "type", "button");
                __builder2.AddAttribute(165, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 73 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                                        (() => AddJobPrivilege())

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(166, "b-ppjh64qbg9");
                __builder2.AddContent(167, "+");
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(168, "\r\n                ");
                __builder2.OpenElement(169, "div");
                __builder2.AddAttribute(170, "class", "job-prv-container");
                __builder2.AddAttribute(171, "b-ppjh64qbg9");
#nullable restore
#line 76 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                     foreach (var element in jobPrivilleges.Select((e, i) => new {Effect = e, Index = i}))
                    {

#line default
#line hidden
#nullable disable
                __builder2.OpenElement(172, "div");
                __builder2.AddAttribute(173, "b-ppjh64qbg9");
                __builder2.OpenElement(174, "input");
                __builder2.AddAttribute(175, "class", "form-control");
                __builder2.AddAttribute(176, "id", 
#nullable restore
#line 79 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                              $"effect{element.Index}"

#line default
#line hidden
#nullable disable
                );
                __builder2.AddAttribute(177, "value", 
#nullable restore
#line 79 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                                                                 element.Effect

#line default
#line hidden
#nullable disable
                );
                __builder2.AddAttribute(178, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.ChangeEventArgs>(this, 
#nullable restore
#line 80 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                                                e => jobPrivilleges[element.Index] = e.Value.ToString()

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(179, "placeholder", "Job Privilege");
                __builder2.AddAttribute(180, "b-ppjh64qbg9");
                __builder2.CloseElement();
                __builder2.CloseElement();
#nullable restore
#line 82 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
                    }

#line default
#line hidden
#nullable disable
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(181, "\r\n            ");
                __builder2.AddMarkupContent(182, "<button class=\"btn btn-dark\" type=\"submit\" b-ppjh64qbg9>Create</button>\r\n            ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.DataAnnotationsValidator>(183);
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(184, "\r\n            ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.ValidationSummary>(185);
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.CloseElement();
            }
            ));
            __builder.CloseComponent();
            __builder.CloseElement();
        }
        #pragma warning restore 1998
#nullable restore
#line 93 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
       
    private JobListing jobListing = new JobListing();
    private List<string> jobRequirements = new List<string>();
    private List<string> jobPrivilleges = new List<string>();
    private DateTime ApplicationDate = DateTime.Now;


    protected override async Task OnInitializedAsync()
    {
        jobRequirements.Add(null);
        jobPrivilleges.Add(null);
    }

    private async void CreateNewJobListing()
    {
        List<string> jobRequirementsCopy = new(jobRequirements);
        foreach (var jr in jobRequirementsCopy)
        {
            if (jr == null) jobRequirements.Remove(jr);
        }
        List<string> jobPrivilegesCopy = new(jobPrivilleges);

        foreach (var jr in jobPrivilegesCopy)
        {
            if (jr == null) jobPrivilleges.Remove(jr);
        }

        jobListing.ApplicationDeadline = ApplicationDate.ToString("dd/MM/yyyy");
        jobListing.JobRequirments = jobRequirements;
        jobListing.JobPrivilleges = jobPrivilleges;
        jobListing.Employer = ((CustomAuthenticationStateProvider) AuthenticationStateProvider).cachedUser.Email;
        

        await JobListingData.CreateJobListing(jobListing);
        IList<JobListing> jbs = await JobListingData.GetJobListings();
        NavigationManager.NavigateTo("/job-listings");
    }

    private void SetJobType(ChangeEventArgs args)
    {
        jobListing.JobType = args.Value.ToString();
    }

    private void AddJobReq()
    {
        if (jobRequirements.Count < 5)
            jobRequirements.Add(null);
    }

    private void AddJobPrivilege()
    {
        if (jobPrivilleges.Count < 5)
            jobPrivilleges.Add(null);
    }


#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private AuthenticationStateProvider AuthenticationStateProvider { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IJobListingData JobListingData { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager NavigationManager { get; set; }
    }
}
namespace __Blazor.WebApplication.Pages.CreateJobListing
{
    #line hidden
    internal static class TypeInference
    {
        public static void CreateInputDate_0<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, System.Object __arg0, int __seq1, TValue __arg1, int __seq2, global::Microsoft.AspNetCore.Components.EventCallback<TValue> __arg2, int __seq3, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg3)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.InputDate<TValue>>(seq);
        __builder.AddAttribute(__seq0, "class", __arg0);
        __builder.AddAttribute(__seq1, "Value", __arg1);
        __builder.AddAttribute(__seq2, "ValueChanged", __arg2);
        __builder.AddAttribute(__seq3, "ValueExpression", __arg3);
        __builder.CloseComponent();
        }
        public static void CreateInputNumber_1<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, System.Object __arg0, int __seq1, System.Object __arg1, int __seq2, System.Object __arg2, int __seq3, TValue __arg3, int __seq4, global::Microsoft.AspNetCore.Components.EventCallback<TValue> __arg4, int __seq5, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg5)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.InputNumber<TValue>>(seq);
        __builder.AddAttribute(__seq0, "Min", __arg0);
        __builder.AddAttribute(__seq1, "class", __arg1);
        __builder.AddAttribute(__seq2, "placeholder", __arg2);
        __builder.AddAttribute(__seq3, "Value", __arg3);
        __builder.AddAttribute(__seq4, "ValueChanged", __arg4);
        __builder.AddAttribute(__seq5, "ValueExpression", __arg5);
        __builder.CloseComponent();
        }
    }
}
#pragma warning restore 1591